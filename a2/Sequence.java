import java.util.Scanner;

public class Sequence<E> {
    protected Object[] data;
    protected int size;

    public Sequence(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        this.data = new Object[n];
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void append(E element) {
        if (this.size < this.data.length) {
            this.data[this.size] = element;
        } else {
            Object[] temp = new Object[this.size + 1];
            System.arraycopy(this.data, 0, temp, 0, this.size);
            this.data = temp;
            this.data[this.size] = element;
        }
        this.size++;
    }

    public Object get(int k) throws IndexOutOfBoundsException {
        if (k < 0 || k >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return this.data[k];
    }

    public void print() {
        System.out.print("\nCurrent Sequence: ");
        for (int i = 0; i < this.size(); i++) {
            System.out.print(this.get(i) + " ");
        }
        System.out.println();
    }

    public void insert(int index, E newElement) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        } else if (index == this.size) {
            this.append(newElement);
        } else {
            // check the size and length
            if (this.size < this.data.length) {
                Object pre = this.data[index];
                this.data[index++] = newElement;
                while (index < this.size && this.data[index] != null) {
                    Object temp = this.data[index];
                    this.data[index++] = pre;
                    pre = temp;
                }
                this.data[index] = pre;
            } else {
                Object[] temp = new Object[this.size + 1];
                System.arraycopy(this.data, 0, temp, 0, index);
                temp[index] = newElement;
                System.arraycopy(this.data, index, temp, index + 1, this.size - index);
                this.data = temp;
            }
            this.size++;
        }
        this.print();
    }

    public void delete(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        } else {
            for (int i = index; i < this.size - 1; i++) {
                this.data[i] = this.data[i + 1];
            }
            this.data[this.size - 1] = null;
            this.size--;
        }
        this.print();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Sequence<Integer> s = new Sequence<Integer>(5);
        s.append(1);
        s.append(2);
        s.append(3);
        s.append(4);
        s.append(5);
        s.print();

        //INSERT CONTROL LOOP HERE
        while (true) {
            System.out.println("Please enter 1 to insert, 2 to delete, or 3 to quit.");
            int choice = in.nextInt();
            if (choice == 1) {
                System.out.println("Please enter the value to insert.");
                int value = in.nextInt();
                System.out.println("Please enter the index to insert.");
                int index = in.nextInt();
                s.insert(index, value);
//                System.out.println(s.size);
            } else if (choice == 2) {
                System.out.println("Please enter the index to delete.");
                int index = in.nextInt();
                s.delete(index);
//                System.out.println(s.size);
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
        in.close();
        System.exit(0);
    }   //End main
}   //End class