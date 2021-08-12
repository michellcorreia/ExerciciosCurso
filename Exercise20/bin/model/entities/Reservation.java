package model.entities;
import model.exceptions.DomainException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Reservation {
    SimpleDateFormat  sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    private Integer roomNumber;
    private Date checkin;
    private Date checkout;


    public Reservation(){
    }
    public Reservation(Integer roomNumber, Date checkin, Date checkout) throws DomainException{
        if(checkout.getTime() < checkin.getTime()){                                            
            throw new DomainException("Check-out date must be after check-in date."); 
        }
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoomNumber(){
        return roomNumber;
    }
    public void setRoomNumber(Integer roomNumber){
        this.roomNumber = roomNumber;
    }
    public Date getCheckin(){
        return checkin;
    }
    public void setCheckin(Date checkin){
        this.checkin = checkin;
    }
    public Date getCheckout(){
        return checkout;
    }
    public void setCheckout(Date checkout){
        this.checkout = checkout;
    }

    public Integer duration(){
        long diff = checkout.getTime() - checkin.getTime();
        int days = (int) (diff / (1000*60*60*24));
        return days;
    }

    public void updateDates(Date checkin, Date checkout, Scanner sc) throws ParseException, DomainException{         // <-- aqui o Scanner da classe Main é passado como argumento, isso possibilita que ele
        Date currentDate = new Date(sdf.parse("19/09/2019").getTime());                             //     seja manuseado normalmente como se fosse declarado aqui.
        
        while(checkout.before(checkin) || checkin.before(currentDate) || checkout.before(currentDate)){
            
            if(checkout.before(checkin)){                                            
                throw new DomainException("Check-out date must be after check-in date."); 
            }
            
            else if(checkin.before(currentDate) || checkout.before(currentDate)) {  
                throw new DomainException("Reservation dates must be future dates.");
            }

            System.out.print("Check-in date (dd/MM/yyyy): ");                                       
            checkin = sdf.parse(sc.nextLine());                                                      
                                                                                                    
            System.out.print("Check-out date (dd/MM/yyyy): ");                                      
            checkout = sdf.parse(sc.nextLine());                                                   
        }
        this.checkin = checkin;                                                                     // IMPORTANTE: Se um método tiver a declaração e fechamento do Scanner dentro de seu corpo,
        this.checkout = checkout;                                                                   // o fechamento não irá só finalizar a variável do tipo Scanner no método, ela irá fechar
    }                                                                                               // por completo o System.in, inviabilizando novos inputs. Se esse método for chamado na
                                                                                                    // classe main, a finalização do System.in dentro do método, também finalizará o System.in
                                                                                                    // dentro do da classe main que o método foi invocado. 
                                                                                                    // Por isso é importante passar o Scanner do Main como argumento, não sendo necessário o fechamento.

    @Override
    public String toString(){
        return "Reservation: Room " +
                getRoomNumber() +
                ", check-in: " +
                sdf.format(getCheckin()) +
                ", check-out: " +
                sdf.format(getCheckout()) +
                ", " +
                duration() +
                " night(s)";
    }
}
