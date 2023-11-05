package ru.rsatu.cursach;


import jakarta.servlet.annotation.WebServlet;
import ru.rsatu.cursach.service.Service;

import javax.inject.Inject;

@WebServlet("/time")
public class MainServlet {

    private final Service service;

    @Inject
    public MainServlet(Service service) {
        this.service = service;
    }
}
