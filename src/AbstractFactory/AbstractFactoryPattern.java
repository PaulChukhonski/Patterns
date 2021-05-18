package AbstractFactory;

public class AbstractFactoryPattern {
    interface CarFactory {
        void createSedan();
        void createCoupe();
    }

    static class BmwFactory implements CarFactory {

        @Override
        public void createSedan() {
            new BmwSedan();
        }

        @Override
        public void createCoupe() {
            new BmwCoupe();
        }
    }

    static class SuzukiFactory implements CarFactory {

        @Override
        public void createSedan() {
            new SuzukiSedan();
        }

        @Override
        public void createCoupe() {
            new SuzukiCoupe();
        }
    }

    interface Sedan {

    }

    interface Coupe {

    }

    static class BmwSedan implements Sedan {
        BmwSedan() {
            System.out.println("BmwSedan created.");
        }
    }

    static class BmwCoupe implements Coupe {
        BmwCoupe() {
            System.out.println("BmwCoupe created.");
        }
    }

    static class SuzukiSedan implements Sedan {
        SuzukiSedan() {
            System.out.println("SuzukiSedan created.");
        }
    }

    static class SuzukiCoupe implements Coupe {
        SuzukiCoupe() {
            System.out.println("SuzukiCoupe created.");
        }
    }

    public static void main(String[] args) {
        CarFactory bmwFactory = new BmwFactory();
        CarFactory suzukiFactory = new SuzukiFactory();
        bmwFactory.createSedan();
        suzukiFactory.createCoupe();
    }
}
