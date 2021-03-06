package mate.academy.internetshop.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mate.academy.internetshop.lib.Inject;
import mate.academy.internetshop.model.Bucket;
import mate.academy.internetshop.model.Item;
import mate.academy.internetshop.service.BucketService;
import mate.academy.internetshop.service.ItemService;

public class AddItemToBucketController extends HttpServlet {

    @Inject
    private static BucketService bucketService;

    @Inject
    private static ItemService itemService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Long userId = (Long) req.getSession().getAttribute("userId");

        Bucket bucket = bucketService.getByUserId(userId);

        String itemId = req.getParameter("item_id");
        Item item = itemService.get(Long.valueOf(itemId));

        bucketService.addItem(bucket, item);

        resp.sendRedirect(req.getContextPath() + "/servlet/getBucket");

    }
}
