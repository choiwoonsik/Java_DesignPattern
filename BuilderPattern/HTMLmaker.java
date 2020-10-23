package BuilderPattern;

public class HTMLmaker {
    public static void main(String[] args) {
         HTML html = new HTML.HTMLbuilder()
                 .setTitle("제목")
                 .setBody(("내용"))
                 .setLi("항목1", "항목2", "항목3", "항목4")
                 .makeHTML();
         
        System.out.println(html);
    }
}
