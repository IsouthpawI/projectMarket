package sk.itsovy.projectMarket.bill;

import sk.itsovy.projectMarket.Application;
import sk.itsovy.projectMarket.Exception.BillException;
import sk.itsovy.projectMarket.interfaces.DrafInterface;
import sk.itsovy.projectMarket.interfaces.Pc;
import sk.itsovy.projectMarket.items.Fruit;
import sk.itsovy.projectMarket.items.Item;

import java.util.ArrayList;
import java.util.List;

import static sk.itsovy.projectMarket.main.Global.MAXITEMS;

public class Bill extends Application {

    public int count;

    private List<Item> list;

    public Bill() {
       this.list = new ArrayList<>();
    }

    public void addItem(Item item) throws BillException {

        list.add(item);
        if(item!=null) {
            if (getCount() == MAXITEMS) {
                String message = "Bill is full, max is" + MAXITEMS + "items";
                throw new BillException(message);
            }
        }
    }

    public void removeItem(Item item){

        list.remove(item);

    }

    public double getFinalPrice(){

        throw new UnsupportedOperationException("Method does not exist yet");

    }

    public void print() {
        if (count == 0) {
            System.out.println("Nothing to print. Bill is empty!");
        } else {
            for (Item item : list) {
                if (item instanceof DrafInterface) {
                    System.out.println(item.getName() + " " + ((DrafInterface) item).getVolume() + " ");
                    System.out.println(item.getPrice() + " " + item.getTotalPrice());
                }
                else if(item instanceof Fruit){
                    System.out.println(item.getName() + " " + ((Fruit) item).getWeight() + " ");
                    System.out.println(item.getPrice() + " " + item.getTotalPrice());
                }
                else if(item instanceof Pc) {
                    System.out.println(item.getName() + " " + ((Pc) item).getAmount() + " ");
                    System.out.println(item.getPrice() + " " + item.getTotalPrice());
                }
            }
        }
    }

    public int getCount(){
        return this.list.size();
    }
}