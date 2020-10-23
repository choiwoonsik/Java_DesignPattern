package BuilderPattern;

import java.util.Optional;

public class HTML {
    private String html;

    @Override
    public String toString() {
        return html;
    }

    public static class HTMLbuilder
    {
        private String title;
        private String body;
        private Optional<String[]> li = Optional.empty();

        public HTMLbuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public HTMLbuilder setBody(String body) {
            this.body = body;
            return this;
        }

        public HTMLbuilder setLi(String ... li) {
            if (li.length > 0)
                this.li = Optional.of(li);
            else
                this.li = Optional.empty();
            return this;
        }

        public HTML makeHTML()
        {
            HTML HTML = new HTML();
            StringBuilder sb = new StringBuilder();

            sb.append("<html>").append("\n");

            sb.append("<title>").append(title).append("</title>").append("\n");
            sb.append("<body>").append(body).append("\n");

            sb.append(" <ul>").append("\n");
            if (!li.isEmpty()){
                li.ifPresent(li -> {
                    for (String s : li)
                        sb.append("      ").append("<li>").append(s).append("</li>").append("\n");
                });
            }
            sb.append(" </ul>").append("\n");

            sb.append("</body>").append(body).append("\n");
            sb.append("</html>").append("\n");

            HTML.html = sb.toString();
            return HTML;
        }
    }
}
