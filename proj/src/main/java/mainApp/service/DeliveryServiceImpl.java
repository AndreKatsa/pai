package mainApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dao.DeliveryDAO;
import mainApp.model.Delivery;

@Service
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired
	DeliveryDAO deliveryDAO;
	
	@Override
	public void saveDelivery(Delivery delivery) {
		deliveryDAO.save(delivery);
	}

}
