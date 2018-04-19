package it.redhat.rsdemo.model;

public class ResponseInfo {
    private String message = "empty";
    private String result;
    private String uuid;
    private String email;


    public String getMessage() {
        return message;
    }

    public ResponseInfo setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getResult() {
        return result;
    }

    public ResponseInfo setResult(String result) {
        this.result = result;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public ResponseInfo setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ResponseInfo setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        buffer.append("{ ");
        buffer.append("\"message\": \"").append(message).append("\"");
        if ((result!= null) && (result.length() > 0)){
            buffer.append(", ");
            buffer.append("\"result\": \"").append(result).append("\"");
        }
        if ((uuid!= null) && (uuid.length() > 0)){
            buffer.append(", ");
            buffer.append("\"uuid\": \"").append(uuid).append("\"");
        }
        if ((email!= null) && (email.length() > 0)){
            buffer.append(", ");
            buffer.append("\"email\": \"").append(email).append("\"");
        }
        buffer.append(" }");
        return  buffer.toString();
    }

}
