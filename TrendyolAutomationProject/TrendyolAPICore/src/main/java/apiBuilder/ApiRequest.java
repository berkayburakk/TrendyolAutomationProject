package apiBuilder;

public class ApiRequest {
    private String baseUrl;
    private String serviceEndpoint;

    public ApiRequest(ApiRequestBuilder builder) {
        this.baseUrl = builder.baseUrl;
        this.serviceEndpoint = builder.serviceEndpoint;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
    public String getEndpoint() {
        return serviceEndpoint;
    }

    public String generateRequestString(){
        StringBuilder sb = new StringBuilder();
        sb.append(baseUrl);
        sb.append("/");
        sb.append(serviceEndpoint);
        return sb.toString();
    }

    public static class ApiRequestBuilder{
        private String baseUrl,serviceEndpoint;

        public ApiRequestBuilder() { }

        public ApiRequestBuilder baseUrl(String baseUrl){
            this.baseUrl = baseUrl;
            return this;
        }
        public ApiRequestBuilder serviceEndpoint(String serviceEndpoint){
            this.serviceEndpoint = serviceEndpoint;
            return this;
        }
        public ApiRequest build(){
            return new ApiRequest(this);
        }
    }

}
