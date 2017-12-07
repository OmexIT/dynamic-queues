package com.omexit.dynamicqueues;

import lombok.Data;

@Data
public class PaymentChannel {
	Long id;
	String channelName;
	String brokerEndpoint;
}
