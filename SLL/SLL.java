public class SLL {
    private Node head;

    public SLL() {
        this.head = null;
    }

    public Node add(int value) {
        if(this.head == null) {
            this.head = new Node(value);
            return this.head;
        }
        Node runner = this.head;

        while(runner.next != null){
            runner = runner.next;
        }

        runner.next = new Node(value);
        return this.head;
    }

    public Node remove(){
        Node runner = this.head;

        while(runner.next.next != null) {
            runner = runner.next;
        }
        runner.next = null;

        return this.head;
    }

    public Node removeAt(int index){
        Node runner = this.head;
        Node tmp  = null;
        int count = 0;

        while(runner.next != null) {
            if(count == index){
                tmp.next = tmp.next.next; //skipping over the node index, therefore deleting it, cause thats how SLLs. if no one acknowledges you exist, do you??
                break;
            }

            tmp = runner;
            runner = runner.next;
            count ++;
        }
        return this.head;
    }

    public void printValues(){
        Node runner = this.head;

        while(runner != null) {
            System.out.println(runner.value);
            runner = runner.next;
        }
    }
}