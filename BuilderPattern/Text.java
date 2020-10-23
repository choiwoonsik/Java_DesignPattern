package BuilderPattern;

import java.util.Optional;

public class Text {
    private String text;

    @Override
    public String toString() {
        return text;
    }

    public static class Builder {
        private String title;
        private String content;
        private Optional<String[]> items = Optional.empty();

        public Builder setTitle(String title){
            this.title = title;
            return this;
        }
        public Builder setContent(String content) {
            this.content = content;
            return this;
        }
        public Builder setItems (String ...  items) {
            if (items.length > 0)
                this.items = Optional.of(items);
            else
                this.items = Optional.empty();
            return this;
        }

        public Text build() {
            Text Text = new Text();

            StringBuilder sb = new StringBuilder();
            sb.append("타이틀 : ").append(title).append("\n");
            sb.append("내용 : ").append(content).append("\n");
            sb.append("항목 : ").append("\n");
            if (items.isEmpty())
                sb.append(" - ").append("null").append("\n");
            else {
                for (String item : items.get())
                    sb.append(" - ").append(item).append("\n");
            }
            Text.text = sb.toString();
            return Text;
        }
    }
}
