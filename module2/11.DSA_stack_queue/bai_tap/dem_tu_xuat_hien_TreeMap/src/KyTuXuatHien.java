public class KyTuXuatHien {
    private Character element;
    int count = 1;

    KyTuXuatHien() {
    }

    KyTuXuatHien(Character element) {
        this.element = element;
    }

    public void addCount() {
        count++;
    }

    @Override
    public String toString() {
        return "KyTuXuatHien{" +
                "element=" + element +
                ", count=" + count +
                '}';
    }
}
