package com.qualle.trip.service.enums;

import com.qualle.trip.controller.list.AllowanceListController;
import com.qualle.trip.controller.list.EmployeeListController;
import com.qualle.trip.controller.list.TicketListController;
import com.qualle.trip.controller.list.TripListController;
import lombok.Getter;

@Getter
public enum PageType {

    ALLOWANCE(AllowanceListController.class),
    TICKET(TicketListController.class),
    TRIP(TripListController.class),
    EMPLOYEE(EmployeeListController.class);

    final Class cls;

    PageType(Class cls) {
        this.cls = cls;
    }
}
