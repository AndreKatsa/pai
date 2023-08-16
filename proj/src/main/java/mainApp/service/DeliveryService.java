package mainApp.service;

import org.springframework.stereotype.Service;

import mainApp.model.Delivery;

@Service
public interface DeliveryService {
	public void saveDelivery(Delivery delivery);
}
