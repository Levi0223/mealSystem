package ctrl;

import service.DCService;
import service.FoodService;
import service.FoodTypeService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "CenterController", urlPatterns = "*.cc")
public class CenterController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String path = request.getServletPath();
        HttpSession session = request.getSession();
        path = path.substring(path.lastIndexOf("/") + 1, path.indexOf(".cc"));
        if (path.equals("login")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            UserService service = new UserService();
            Map<String, String> user = service.getUserInfo(username, password);
            if (user == null) {
                request.setAttribute("msg", "用户名或密码错误！");
                request.setAttribute("href", request.getContextPath() + "/login.html");
                request.getRequestDispatcher("/result.jsp").forward(request, response);
            } else {
                request.getSession().setAttribute("login_id", user.get("id"));
                request.getSession().setAttribute("login_name", username);
                if (user.get("ident").equals("0")) {
                    response.sendRedirect("user/user_index.cc");
                } else {
                    response.sendRedirect("admin_index.cc");
                }
            }
        } else if (path.equals("homepage")) {
            FoodService foodService = new FoodService();
            request.setAttribute("hot", foodService.getHotFood());
            request.setAttribute("cheap", foodService.getCheapFood());
            request.setAttribute("chiefRecommend", foodService.getChiefRecommend());
            request.getRequestDispatcher("/homepage.jsp").forward(request, response);
        } else if (path.equals("register")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String identity = request.getParameter("identity");
            String tel = request.getParameter("tel");
            String address = request.getParameter("address");
            UserService service = new UserService();
            int rows = service.addUser(username, password, identity, tel, address);
            if (rows >= 1) {
                request.setAttribute("msg", "注册成功");
            } else {
                request.setAttribute("msg", "注册失败");
            }
            request.setAttribute("href", request.getContextPath() + "/register.html");
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        } else if (path.equals("show_detail")) {
            String id = request.getParameter("id");
            FoodService foodService = new FoodService();
            request.setAttribute("food", foodService.getFoodInfoById(id));
            request.getRequestDispatcher("/show_detail.jsp").forward(request, response);
        } else if (path.equals("user_index")) {
            FoodService foodService = new FoodService();
            FoodTypeService foodTypeService = new FoodTypeService();
            String type = request.getParameter("type");
            String sn = request.getParameter("sn");
            if (type != null && !type.equals("")) {
                if (sn != null && !sn.equals("")) {
                    request.setAttribute("allFood", foodService.getFoodByNameAndType(type, sn));
                } else {
                    request.setAttribute("allFood", foodService.getFoodByType(type));
                }
            } else {
                if (sn != null && !sn.equals("")) {
                    request.setAttribute("allFood", foodService.getFoodByName(sn));
                } else {
                    request.setAttribute("allFood", foodService.getFoodInfo());
                }
            }
            request.setAttribute("foodTypes", foodTypeService.getAllFoodTypes());
            request.getRequestDispatcher("/user/user_index.jsp").forward(request, response);
        } else if (path.equals("user_add_dc")) {
            String[] f_ids = request.getParameterValues("FIds");
            String user_id = (String) session.getAttribute("login_id");
            int rows = new DCService().addToDC(user_id, f_ids);
            request.setAttribute("msg", "成功将" + rows + "个菜品加入点餐车！");
            request.setAttribute("href", request.getContextPath() + "/user/user_show_dc.cc");
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        } else if (path.equals("user_show_dc")) {
            //用户查看点餐车
            String user_id = (String) session.getAttribute("login_id");
            request.setAttribute("dc", new DCService().getUserDc(user_id));
            request.getRequestDispatcher("/user/user_show_dc.jsp").forward(request, response);
        } else if (path.equals("user_del_dc")) {
            String[] dc_ids = request.getParameterValues("DcIds");
            int rows = new DCService().delFromDc(dc_ids);
            request.setAttribute("msg", "成功将" + rows + "个菜品删除点餐车！");
            request.setAttribute("href", request.getContextPath() + "/user/user_show_dc.cc");
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        } else if (path.equals("user_edit")) {
            String user_id = (String) session.getAttribute("login_id");
            request.getRequestDispatcher("user/user_edit.jsp").forward(request, response);
        } else if (path.equals("user_update")) {
            String user_id = (String) session.getAttribute("login_id");
            String password = request.getParameter("password");
            String tel = request.getParameter("tel");
            String addr = request.getParameter("address");
            UserService service = new UserService();
            int rows = service.updateUserInfo(user_id, password, tel, addr);
            if (rows == 1) {
                request.setAttribute("msg", "修改用户信息成功");
            } else {
                request.setAttribute("msg", "修改用户信息失败");
            }
            request.setAttribute("href", request.getContextPath() + "/user_edit.cc");
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        } else if (path.equals("user_exit")) {
            response.sendRedirect("homepage.cc");
        }
    }
}
