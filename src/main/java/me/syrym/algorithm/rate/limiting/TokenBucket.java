package me.syrym.algorithm.rate.limiting;

/**
 *
 */
public class TokenBucket {
    private final long maxBucketSize;
    private final long refillRate;

    private double currentBucketSize;
    private long lasRefillTimestamp;

    public TokenBucket(long maxBucketSize, long refillRate) {
        this.maxBucketSize = maxBucketSize;
        this.refillRate = refillRate;

        currentBucketSize = maxBucketSize;
        lasRefillTimestamp = System.nanoTime();
    }

    public synchronized boolean allowRequest(int tokens) {
        refill();

        if (currentBucketSize > tokens) {
            currentBucketSize -= tokens;
            return true;
        }

        return false;
    }

    private void refill() {
        long now = System.nanoTime();
        double tokensToAdd = (now - lasRefillTimestamp) * refillRate / 1e9;
        currentBucketSize = Math.min(currentBucketSize + tokensToAdd, maxBucketSize);
        lasRefillTimestamp = now;
    }
}
