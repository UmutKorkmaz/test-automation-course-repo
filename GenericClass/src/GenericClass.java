public class GenericClass<T> {
    private T field;

    public GenericClass(T field) {
        this.field = field;
    }

    public void printField() {
        System.out.println("Field value: " + field);
    }
}
