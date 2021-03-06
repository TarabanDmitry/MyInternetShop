package mate.academy.internetshop.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mate.academy.internetshop.lib.Inject;
import mate.academy.internetshop.service.ItemService;

public class DeleteItemController extends HttpServlet {

    @Inject
    private static ItemService itemService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String item = req.getParameter("item_id");
        itemService.deleteById(Long.valueOf(item));
        resp.sendRedirect(req.getContextPath() + "/servlet/getAllItems");
    }
}
