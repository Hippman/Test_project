package Service;

import DataBase.Entities.Goods;
import DataBase.Entities.Order;
import DataBase.Repository.GoodsRepo;
import DataBase.Repository.OrderRepo;
import DataBase.Repository.Order_lineRepo;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

@RestController
public class ServiceController {
    private static ConfigurableApplicationContext context;
    private GoodsRepo goodsRepo;
    private OrderRepo orderRepo;
    private Order_lineRepo order_lineRepo;
    public ServiceController()
    {

    }
    //-----------------------------------------------------------------------------------------------------------------
    @RequestMapping( method = RequestMethod.GET,value="/getAllGoods")
    public Iterable<Goods> getAllGoods() throws ServiceException {
        GoodsRepo repository = getGoodsRepo();
        return repository.findAll();
    }
    @RequestMapping( method = RequestMethod.GET,value="/getGoodsByID")
    public Goods getGoodsByID(@RequestParam(value="id",required=true) Integer id) throws ServiceException {
        GoodsRepo repository = getGoodsRepo();
        return repository.findById(id);
    }
    @RequestMapping( method = RequestMethod.GET,value="/createGoods")
    public Goods createGoods(
                             @RequestParam(value="name",required=true) String name,
                             @RequestParam(value="price",required=true) Double price) throws ServiceException {
        GoodsRepo repository = getGoodsRepo();
        Goods tmpgoods;
        tmpgoods=new Goods(name,price);
        tmpgoods= repository.save(tmpgoods);
        return tmpgoods;
    }
    @RequestMapping( method = RequestMethod.GET,value="/updateGoodsById")
    public int updateGoodsById(
            @RequestParam(value="id",required=true) Integer id,
            @RequestParam(value="name",required=true) String name,
            @RequestParam(value="price",required=true) Double price) throws ServiceException {
        GoodsRepo repository = getGoodsRepo();
        return repository.updateById(id,name,price);

    }

    @RequestMapping( method = RequestMethod.GET,value="/deleteGoodsById")
    public void deleteGoodsById(
            @RequestParam(value="id",required=true) Integer id) throws ServiceException {
        GoodsRepo repository = getGoodsRepo();
        repository.deleteById(id);
    }


    //-----------------------------------------------------------------------------------------------------------------
    @RequestMapping( method = RequestMethod.GET,value="/getAllOrders")
    public Iterable<Order> getAllOrders() throws ServiceException {
        OrderRepo repository = getOrderRepo();
        Iterable<Order> ret= repository.findAll();
        if(ret!=null) return ret;
        throw new ServiceException(2);
    }
    //Integer id, String client, Calendar date, String address
    @RequestMapping( method = RequestMethod.GET,value="/createOrder")
    public Order createOrder(
            @RequestParam(value="client",required=true) String client,
            @RequestParam(value="dat",required=true) String dat,
            @RequestParam(value="address",required=true) String address) throws ServiceException {
        OrderRepo repository = getOrderRepo();
        Order tmporder;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        Calendar cal= Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(dat));// all done
        } catch (ParseException e) {
            e.printStackTrace();
        }
        tmporder=new Order(client,cal,address);
        tmporder= repository.save(tmporder);
        return tmporder;
    }


    private GoodsRepo getGoodsRepo() throws ServiceException {
        if(goodsRepo==null) {
            if (context == null) throw new ServiceException(1);
            goodsRepo = context.getBean(GoodsRepo.class);
        }
        return goodsRepo;
    }
    private OrderRepo getOrderRepo() throws ServiceException {
        if(orderRepo==null) {
            if (context == null) throw new ServiceException(1);
            orderRepo = context.getBean(OrderRepo.class);
        }
        return orderRepo;
    }
    private Order_lineRepo getOrder_lineRepo() throws ServiceException {
        if(order_lineRepo==null) {
            if (context == null) throw new ServiceException(1);
            order_lineRepo = context.getBean(Order_lineRepo.class);
        }
        return order_lineRepo;
    }
    public static ConfigurableApplicationContext getContext() {
        return context;
    }
    public static void setContext(ConfigurableApplicationContext context) {
        ServiceController.context = context;
    }
}
