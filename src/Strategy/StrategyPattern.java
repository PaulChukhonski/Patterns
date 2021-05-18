package Strategy;

public class StrategyPattern {
    interface Printer {
        String print();
    }

    static class ColorPrinter implements Printer{

        @Override
        public String print() {
            return "Color print!";
        }
    }

    static class BlackWhitePrinter implements Printer{

        @Override
        public String print() {
            return "Black-white print!";
        }
    }

    static class Text {
        Printer printer;

        public Text(Printer printer) {
            this.printer = printer;
        }

        public String print() {
            return printer.print();
        }
    }

    public static void main(String[] args) {
        Text text1 = new Text(new ColorPrinter());
        Text text2 = new Text(new BlackWhitePrinter());
        System.out.println(text1.print());
        System.out.println(text2.print());
    }
}