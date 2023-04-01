package Test_Colloection;

import java.util.*;

public class Example_Arraylist {
    Scanner scan = new Scanner(System.in);
    private int id;
    private  String name;
    private float dis,qty,price;
    
    public String getName(){
        return name;
    }
    public void Input(){
        Random rand = new Random();
        id = rand.nextInt() % 100;
        System.out.print("Input Name      : "); name = scan.next();
        System.out.print("Input Quantity  : "); qty = scan.nextFloat();
        System.out.print("Input Price     : "); price = scan.nextFloat();
    }
    public double Total(){
        return qty*price;
    }
    public float Discount(){
        if(Total()>=10 && Total()<20){
            dis = 5;
        }else if(Total()>=20 && Total()<30){
            dis = 10;
        }else if(Total()>=30 && Total()<40){
            dis = 15;
        }else if(Total()>=40 && Total()<50){
            dis = 20;
        }else{
            dis = 25;
        }
        return dis;
    }
    public double Payment(){
        return Total() - (Total()*dis)/100;
    }
    public void Output(){
        System.out.println("\t"+id+"\t"+name+"\t"+qty+"\t\t$ "+price+"\t$ "+Total()+"\t%"+Discount()+"\t\t$ "+Payment());
    }
    static void Header(){
        System.out.println("\tId\tName\tQuantity\t\tPrice\tTotal\tDiscount\t\tPayment");
    }
    public static void main(String[] args) {
        ArrayList <Example_Arraylist> list = new ArrayList<>();
        Example_Arraylist obj = new Example_Arraylist();
        Scanner scan = new Scanner(System.in);
        int i,n=0,j,op=0;
        do {            
            System.out.println("1. Input\t\t2. Output\t3. Search\t4. Update\t5. Remove\n6. Insert\t7. Sort\t\t8. Add\t\t9. Clear\t\t10. Exit");
            System.out.print("Please Choose Option : "); op = scan.nextInt();
            switch(op){
                case 1->{
                    System.out.print("Input Number of your product : "); n = scan.nextInt();
                    for(i=0;i<n;i++){
                        System.out.println("--------------- [ #"+(i+1)+" ] ---------------");
                        obj = new Example_Arraylist();
                        obj.Input();
                        list.add(obj);
                    }
                }
                case 2->{
                    Header();
                    for(i=0;i<list.size();i++){
                        list.get(i).Output();
                    }
                }
                case 3->{
                    String search;
                    System.out.print("Input name for search : "); search = scan.next();
                    for(i=0;i<list.size();i++){
                        if(search.equalsIgnoreCase(list.get(i).getName())){
                            list.get(i).Output();
                        }
                    }
                }
                case 4->{
                    String update;
                    System.out.print("Input name for update : "); update = scan.next();
                    for(i=0;i<list.size();i++){
                        if(update.equalsIgnoreCase(list.get(i).getName())){
                            obj = new Example_Arraylist();
                            obj.Input();
                            list.set(i, obj);
                        }
                    }
                }
                case 5->{
                    String remove;
                    System.out.print("Input Name for Remove : "); remove = scan.next();
                    for(i=0;i<list.size();i++){
                        if(remove.equalsIgnoreCase(list.get(i).getName())){
                            list.remove(i);
                        }
                    }
                }
                case 6->{
                    String insert;
                    System.out.print("Input Name for insert : "); insert = scan.next();
                    for(i=0;i<list.size();i++){
                        if(insert.equalsIgnoreCase(list.get(i).getName())){
                            obj = new Example_Arraylist();
                            obj.Input();
                            list.add(i,obj);
                            break;
                        }
                    }
                }
                case 7->{
                    Collections.sort(list, Comparator.comparing(Example_Arraylist::getName));
                }
                case 8->{
                    int add;
                    System.out.print("Add more : "); add = scan.nextInt();
                    for(i=n;i<n+add;i++){
                        obj = new Example_Arraylist();
                        obj.Input();
                        list.add(i,obj);
                    }n+=add;
                }
                case 9->{
                    list.clear();
                }
            }
        }while(op!=10);
    }
}
