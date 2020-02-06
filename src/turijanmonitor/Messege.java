package turijanmonitor;

public class Messege {
	

    protected int    beginLine;
    protected int    endLine;
    protected char   messageType;
    protected String mix;
    protected String time;
    protected String codeSubcode;
    protected String messageNumber;
    protected String version;
    protected String content;
    protected String referenceType;
    protected String reference;

    public void setMessage(String messageContent) {
        this.content = messageContent;
    }

    public String getMessage() {
        return this.content;
    }

    @Override
    public String toString() {
        return "Begin: "            + this.beginLine     +
               "\nEnd: "            + this.endLine       +
               "\nMix: "            + this.mix           + 
               "\nType: "           + this.messageType   + 
               "\nTime: "           + this.time          +
               "\nCod-Sub: "        + this.codeSubcode   +
               "\nVersion: "        + this.version       +
               "\nMessage Number: " + this.messageNumber +
               "\nreference: "      + this.reference     +
               "\nreferenceType: "  + this.referenceType +
               "\nContent: "        + this.content;
    }

}
