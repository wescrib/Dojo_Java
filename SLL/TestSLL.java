public class TestSLL{

public static void main(String[] args) {
    SLL sll = new SLL();
    sll.add(31);
    sll.add(20);
    sll.add(49);
    sll.add(20);

    sll.removeAt(1);
    sll.add(5000);
    sll.remove();
    sll.printValues();
    }
}