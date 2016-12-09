package nju.quadra.hms.controller;

import nju.quadra.hms.blservice.*;
import nju.quadra.hms.model.ResultMessage;
import nju.quadra.hms.net.BLServiceFactory;
import nju.quadra.hms.vo.*;

import java.util.ArrayList;

/**
 * Created by adn55 on 2016/11/30.
 */
public class HotelStaffController {

    private final HotelBLService hotelBL = BLServiceFactory.getHotelBLService();
    private final HotelRoomBLService hotelRoomBL = BLServiceFactory.getHotelRoomBLService();
    private final HotelPromotionBLService hotelPromotionBL = BLServiceFactory.getHotelPromotionBLService();
    private final CustomerBLService customerBL = BLServiceFactory.getCustomerBLService();
    private final OrderBLService orderBL = BLServiceFactory.getOrderBLService();

    private final HotelVO hotelVO;

    public HotelStaffController(String username) {
        hotelVO = hotelBL.getByStaff(username);
    }

    public ArrayList<AreaVO> getAllArea() {
        try {
            return hotelBL.getAllArea();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public HotelVO getHotelInfo() {
        try {
            return hotelVO;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultMessage modifyHotelInfo(HotelVO vo) {
        try {
            return hotelBL.modify(vo);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMessage(ResultMessage.RESULT_NET_ERROR);
        }
    }

    public ArrayList<HotelRoomVO> getHotelRooms() {
        try {
            return hotelRoomBL.getAll(hotelVO.id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultMessage addHotelRoom(HotelRoomVO vo) {
        vo.hotelId = this.hotelVO.id;
        try {
            return hotelRoomBL.add(vo);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMessage(ResultMessage.RESULT_NET_ERROR);
        }
    }

    public ResultMessage modifyHotelRoom(HotelRoomVO vo) {
        try {
            return hotelRoomBL.modify(vo);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMessage(ResultMessage.RESULT_NET_ERROR);
        }
    }

    public ResultMessage deleteHotelRoom(int id) {
        try {
            return hotelRoomBL.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMessage(ResultMessage.RESULT_NET_ERROR);
        }
    }

    public ArrayList<HotelPromotionVO> getHotelPromotion() {
        try {
            return hotelPromotionBL.get(hotelVO.id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultMessage addHotelPromotion(HotelPromotionVO vo) {
        vo.hotelId = this.hotelVO.id;
        try {
            return hotelPromotionBL.add(vo);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMessage(ResultMessage.RESULT_NET_ERROR);
        }
    }

    public ResultMessage modifyHotelPromotion(HotelPromotionVO vo) {
        try {
            return hotelPromotionBL.modify(vo);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMessage(ResultMessage.RESULT_NET_ERROR);
        }
    }

    public ResultMessage deleteHotelPromotion(int id) {
        try {
            return hotelPromotionBL.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMessage(ResultMessage.RESULT_NET_ERROR);
        }
    }

    public ArrayList<String> getAllCompany() {
        try {
            return customerBL.getAllCompany();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<OrderDetailVO> getOrders() {
        try {
            return orderBL.getByHotel(hotelVO.id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultMessage checkinOrder(int orderId) {
        try {
            return orderBL.checkin(orderId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMessage(ResultMessage.RESULT_NET_ERROR);
        }
    }

    public ResultMessage checkoutOrder(int orderId) {
        try {
            return orderBL.checkout(orderId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMessage(ResultMessage.RESULT_NET_ERROR);
        }
    }

}
