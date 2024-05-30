package br.com.lmello.redventures.ramengo.infra.exception;

public class MaxLimitReachedException extends RuntimeException {
    public MaxLimitReachedException(String apiKey, int usageQuota) {
        super("'" + apiKey + "' exceeded maximum limit of " + usageQuota);
    }
}
