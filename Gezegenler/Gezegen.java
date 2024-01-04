public class Gezegen {

    // Gezegenler için enum tanımı
    public enum Gezegenler {
        MERKUR(1, 57.9, 2439, 58.6),
        VENUS(2, 108.2, 6052, 243),
        DUNYA(3, 149.6, 6371, 1),
        MARS(4, 227.9, 3390, 1.03),
        JUPITER(5, 778.5, 69911, 0.41),
        SATURN(6, 1434, 58232, 0.45),
        URANUS(7, 2871, 25362, 0.72),
        NEPTUN(8, 4495, 24622, 0.67);

        private final int siralama;
        private final double uzaklik; // Güneş'e olan ortalama uzaklık (milyon km cinsinden)
        private final double yaricap; // Km cinsinden
        private final double donmeSuresi; // Dünya günü cinsinden

        // Gezegenler enum'ının yapıcı metodu
        Gezegenler(int siralama, double uzaklik, double yaricap, double donmeSuresi) {
            this.siralama = siralama;
            this.uzaklik = uzaklik;
            this.yaricap = yaricap;
            this.donmeSuresi = donmeSuresi;
        }

        // toString metodu, gezegen hakkında bilgileri döndürür
        @Override
        public String toString() {
            return this.name() + ":\n" +
                    "Güneş'e Olan Sıralama: " + siralama + "\n" +
                    "Ortalama Uzaklık (milyon km): " + uzaklik + "\n" +
                    "Yarıçap (km): " + yaricap + "\n" +
                    "Dönme Süresi (Dünya günü): " + donmeSuresi + "\n";
        }
    }

    // Ana metod, enum örneği ve switch ifadesi kullanımını gösterir
    public static void main(String[] args) {
        for (Gezegenler gezegen : Gezegenler.values()) {
            switch (gezegen) {
                case DUNYA:
                case MARS:
                    System.out.println(gezegen + "Yaşanabilir olabilir.\n");
                    break;
                default:
                    System.out.println(gezegen + "Yaşanabilir değildir.\n");
            }
        }
    }
}
