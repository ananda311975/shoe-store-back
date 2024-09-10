package com.it.rmu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.it.rmu.model.OrderRequestModel;

import com.it.rmu.model.ResponseModel;
import com.it.rmu.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	 @GetMapping("/getById")
	    public ResponseModel getById(@RequestParam(name = "ordersId") Integer ordersId) {

	        ResponseModel response = new ResponseModel();

	        try {
	            // service
	            response.setData(orderService.getById(ordersId));
	            response.setStatus("SUCCESS");
	        } catch (Exception e) {
	            // TODO: handle exception
	            response.setStatus("ERROR");
	            response.setMessage(e.getMessage());
	        }

	        return response;
	    }

	 @GetMapping("/getByUserId")
	    public ResponseModel getByUserId(@RequestParam(name = "userId") Integer userId) {
	        ResponseModel response = new ResponseModel();

	        try {
	            // Call the service to get the data
	            response.setData(orderService.getByUserId(userId));
	            response.setStatus("SUCCESS");
	        } catch (Exception e) {
	            response.setStatus("ERROR");
	            response.setMessage(e.getMessage());
	        }

	        return response;
	    }

	@GetMapping("/getAll")
	public ResponseModel getAll() {
		ResponseModel response = new ResponseModel();
		
		try {
			// service
			response.setData(orderService.getAll());
			response.setStatus("SUCCESS");
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus("ERROR");
			response.setMessage(e.getMessage());
		}

		return response;
	}
	@PostMapping("/save")
	public ResponseModel save(@RequestBody OrderRequestModel request) {
		ResponseModel response = new ResponseModel();
		
		try {
			// service
			response.setData(orderService.save(request));
			response.setStatus("SUCCESS");
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus("ERROR");
			response.setMessage(e.getMessage());
		}

		return response;
	}
	@PutMapping("/update/{orderId}")
	public ResponseModel update(@RequestBody OrderRequestModel request, @PathVariable Integer orderId) {
	    ResponseModel response = new ResponseModel();

	    try {
	        // Call the service to update the order
	        response.setData(orderService.update(request, orderId));
	        response.setStatus("SUCCESS");
	    } catch (Exception e) {
	        // Handle exceptions and set the error response
	        response.setStatus("ERROR");
	        response.setMessage(e.getMessage());
	    }

	    return response;
	}


//	@PutMapping("/update/{orderId}")
//	public ResponseModel update(@RequestBody OrderRequestModel request, @PathVariable Integer orderId) {
//	    ResponseModel response = new ResponseModel();
//
//	    try {
//	        Integer updatedOrderId = orderService.update(request, orderId); 
//	        response.setData(updatedOrderId);
//	        response.setStatus("SUCCESS");
//	    } catch (Exception e) {
//	        response.setStatus("ERROR");
//	        response.setMessage(e.getMessage());
//	    }
//
//	    return response;
//	}
	@DeleteMapping("/delete")
	public ResponseModel delete(@RequestParam(name = "ordersId") Integer ordersId) {
		
		ResponseModel response = new ResponseModel();
		
		try {
			response.setData(orderService.delete(ordersId));
			response.setStatus("SUCCESS");
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus("ERROR");
			response.setMessage(e.getMessage());
		}
		
		return response;
	}
}
