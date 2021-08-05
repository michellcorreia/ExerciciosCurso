package entities;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import entities.enums.OrderStatus;

public class Order {

    private Date moment;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> list = new ArrayList<>();
    

    public Order(){    
    }
    public Order(Client client, OrderStatus status, Date moment){
        this.client = client;
        this.status = status;
        this.moment = moment;
    }
   
    public Date getMoment(){
        return moment;
    }
    public void setMoment(Date moment){
        this.moment = moment;
    }
    public OrderStatus getStatus(){
        return status;
    }
    public void setStatus(OrderStatus status){
        this.status = status;
    }
    public Client getClient(){
        return client;
    }
    public void setClient(Client client){
        this.client = client;
    }
    public List<OrderItem> getList(){
        return list;
    }
    public void addItem(OrderItem item){
        list.add(item);
    }
    public void removeItem(OrderItem item){
        list.remove(item);
    }

    public Double total(){
        Double sum = 0.00;
        for(int i=0; i<list.size(); i++){
            sum += list.get(i).subTotal();
        }
        return sum;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i).getProduct().getName() + ", $");
            sb.append(String.format("%.2f", list.get(i).getProduct().getPrice()) + ", Quantity: ");
            sb.append(list.get(i).getQuantity() + ", Subtotal: $");
            sb.append(String.format("%.2f", list.get(i).subTotal()));
            if(i != (list.size()-1)){
                sb.append("\n");
            }
        }
        return sb.toString();
    }


}
