package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;
import model.giftRegistry;
import model.gifter;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	giftListHelper glh = new giftListHelper();
	String listName = request.getParameter("listName");

	
	String month = request.getParameter("month");
	String day = request.getParameter("day");
	String year = request.getParameter("year");
	String gifterName = request.getParameter("gifter");
	
	LocalDate ld;
	
	try {
		ld = LocalDate.of(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day));
	}catch(NumberFormatException ex) {
		ld=LocalDate.now();
	}
	
	String[] selectedGifts =  request.getParameterValues("allItemsToAdd");
		List<giftRegistry> selectedGiftsInList = new ArrayList<giftRegistry>();
		
		if (selectedGifts != null && selectedGifts.length > 0) {
			for(int i =0; i<selectedGifts.length; i++) {
				System.out.println(selectedGifts[i]);
				giftRegistry c = glh.searchForItemById(Integer.parseInt(selectedGifts[i]));
				selectedGiftsInList.add(c);
			}
		}
	gifter gifter = new gifter(gifterName);
	ListDetails sld = new ListDetails(listName, ld, gifter);
	
	sld.setListOfGifts(selectedGiftsInList);
	ListDetailsHelper slh = new ListDetailsHelper();
	slh.insertNewListDetails(sld);
	
	System.out.println("Success!");
	System.out.println(sld.toString());
	
	getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
