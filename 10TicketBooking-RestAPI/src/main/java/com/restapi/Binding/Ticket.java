package com.restapi.Binding;



import lombok.Data;
//@XmlRootElement
@Data
public class Ticket {
private Integer ticketid;
private String from;
private String to;
private Integer trainno;
private Integer cost;
private String status;
}
