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
 * Servlet implementation class editListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListDetailsHelper dao = new ListDetailsHelper();
		giftListHelper glh = new giftListHelper();
		gifterHelper gh = new gifterHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listToUpdate = dao.searchForListDetailsById(tempId);
		
		String newListName = request.getParameter("listName");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String gifterName = request.getParameter("gifter");
		//find our add shopper
		gifter newGifter = gh.findGifter(gifterName);
		
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		try {
			//gifts are selected in list to add
			String[] selectedGifts = request.getParameterValues("allItemsToAdd");
			List<giftRegistry> selectedGiftsInList = new ArrayList<giftRegistry>();
			for (int i = 0; i<selectedGifts.length; i++) {
				System.out.println(selectedGifts[i]);
				giftRegistry c = glh.searchForItemById(Integer.parseInt(selectedGifts[i]));
				selectedGiftsInList.add(c);
			}
			listToUpdate.setListOfGifts(selectedGiftsInList);
		} catch (NullPointerException ex) {
			//no items selected in list - set to empty list
			List<giftRegistry> selectedItemsInList = new ArrayList<giftRegistry>();
			listToUpdate.setListOfGifts(selectedItemsInList);

		}
		listToUpdate.setListName(newListName);
		listToUpdate.setTripDate(ld);
		listToUpdate.setGifter(newGifter);
		
		dao.updateList(listToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

}
