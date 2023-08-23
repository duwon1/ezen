package com.ezen.phonefly2.controller;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.phonefly2.dto.BannerVO;
import com.ezen.phonefly2.dto.ColorVO;
import com.ezen.phonefly2.dto.EventVO;
import com.ezen.phonefly2.dto.MemberVO;
import com.ezen.phonefly2.dto.NoticeVO;
import com.ezen.phonefly2.dto.OrderDetailVO;
import com.ezen.phonefly2.dto.ProductVO;
import com.ezen.phonefly2.dto.QnaVO;
import com.ezen.phonefly2.service.AdminService;
import com.ezen.phonefly2.service.CommonService;
import com.ezen.phonefly2.service.MyPageService;
import com.ezen.phonefly2.service.ProductService;
import com.ezen.phonefly2.service.QnaService;
import com.ezen.phonefly2.util.Paging;

@Controller
public class AdminController {
	
	@Autowired
	AdminService as;
	@Autowired
	ProductService ps;
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin/admin";
	}
	
	@Autowired
	ServletContext context;
	
	@RequestMapping(value="fileup", method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> fileup( 
			@RequestParam("fileimage") MultipartFile file,
			HttpServletRequest request, Model model	) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		String path = context.getRealPath("/videos");	
		Calendar today = Calendar.getInstance();
 		long t = today.getTimeInMillis();
 		String filename = file.getOriginalFilename(); // 파일이름 추출
 		String fn1 = filename.substring(0, filename.indexOf(".") );  // 파일이름과 확장장 분리
 		String fn2 = filename.substring(filename.indexOf(".")+1 );
 		
 		if (!file.isEmpty()) {   // 업로드할 파일이 존재한다면
            String uploadPath = path + "/" + fn1 + t +  "." + fn2;
            System.out.println("파일 저장 경로 = " + uploadPath);
            try {
				file.transferTo( new File(uploadPath) );
			} catch (IllegalStateException e) { e.printStackTrace();
			} catch (IOException e) { e.printStackTrace();
			}
 		}
		result.put("STATUS", 1);
		result.put("FILENAME", fn1 + t +  "." + fn2 );
		return result;
	}
	
	@RequestMapping(value="fileupImg", method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> fileupImg( 
			@RequestParam("fileimage") MultipartFile file,
			HttpServletRequest request, Model model	) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		String path = context.getRealPath("/images/productImage");	
		Calendar today = Calendar.getInstance();
 		long t = today.getTimeInMillis();
 		String filename = file.getOriginalFilename(); // 파일이름 추출
 		String fn1 = filename.substring(0, filename.indexOf(".") );  // 파일이름과 확장장 분리
 		String fn2 = filename.substring(filename.indexOf(".")+1 );
 		
 		if (!file.isEmpty()) {   // 업로드할 파일이 존재한다면
            String uploadPath = path + "/" + fn1 + t +  "." + fn2;
            System.out.println("파일 저장 경로 = " + uploadPath);
            try {
				file.transferTo( new File(uploadPath) );
			} catch (IllegalStateException e) { e.printStackTrace();
			} catch (IOException e) { e.printStackTrace();
			}
 		}
		result.put("STATUS", 1);
		result.put("FILENAME", fn1 + t +  "." + fn2 );
		return result;
	}
	
	//관리자 로그인
	@RequestMapping("adminLogin")
	public ModelAndView admin_login(
						@RequestParam(value="workId", required=false) String workId,
						@RequestParam(value="workPwd", required=false) String workPwd, 
						HttpServletRequest request ) {
		ModelAndView mav = new ModelAndView();
		if( workId == null ) {
			mav.addObject("msg" , "아이디를 입력하세요");
			mav.setViewName("admin/admin");
			return mav;
		}else if( workId.equals("") ) {
			mav.addObject("msg" , "아이디를 입력하세요");
			mav.setViewName("admin/admin");
			return mav;
		}else if( workPwd == null) {
			mav.addObject("msg" , "패스워드를 입력하세요");
			mav.setViewName("admin/admin");
			return mav;
		}else if( workPwd.equals("")) {
			mav.addObject("msg" , "패스워드를 입력하세요");
			mav.setViewName("admin/admin");
			return mav;
		}	
		int result = as.workerCheck( workId, workPwd );
		
		if(result == 1) { 
	    		HttpSession session = request.getSession();
	    		session.setAttribute("workId", workId);
	    		mav.setViewName("redirect:/adminProductList");
		} else if (result == 0) {
	        	mav.addObject("message", "비밀번호를 확인하세요.");
	        	mav.setViewName("admin/admin");
		} else if (result == -1) {
	    		mav.addObject("message", "아이디를 확인하세요.");
	    		mav.setViewName("admin/admin");
		}	
		
		return mav;
	}
	
	@RequestMapping("/adminProductList")
	public ModelAndView adminProductList( HttpServletRequest request ) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("workId");
		if(id==null)
			mav.setViewName("redirect:/admin");
		else {
			HashMap<String, Object> result =  as.getAdminProductList( request );
			mav.addObject("adminproductList",  (List<ProductVO>)result.get("AdminProductList")  );
			mav.addObject("paging", (Paging)result.get("paging") );
			mav.addObject("key", (String)result.get("key") );
			mav.setViewName("admin/product/adminProductList");
			// Controller 는 Service 가 작업해서 보내준 결과들을 mav 에 잘 넣어서 목적지로 이동만 합니다.
		}
		return mav;
	}

	
	@RequestMapping("/adminMemberList")
	public ModelAndView adminMemberList(HttpServletRequest request) {
	    ModelAndView mav = new ModelAndView();
	    HttpSession session = request.getSession();
	    String id = (String) session.getAttribute("workId");
	    if (id == null) {
	        mav.setViewName("redirect:/admin");
	    } else {
	        HashMap<String, Object> result = as.getMemberList(request);
	        mav.addObject("memberList", (List<MemberVO>) result.get("memberList"));
	        mav.addObject("paging", (Paging) result.get("paging"));
	        mav.addObject("key", (String) result.get("key"));
	        mav.setViewName("admin/member/adminMemberList");
	    }
	    return mav;
	}
	
	
	@RequestMapping("/adminQnaList")
	public ModelAndView adminQnaList( HttpServletRequest request ) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("workId");
		if(id==null)
			mav.setViewName("redirect:/admin");
		else {
			HashMap<String, Object> result =  as.getQnaList( request );
			mav.addObject("qnaList",  (List<QnaVO>)result.get("qnaList")  );
			mav.addObject("paging", (Paging)result.get("paging") );
			mav.addObject("key", (String)result.get("key") );
			mav.setViewName("admin/qna/adminQnaList");
			// Controller 는 Service 가 작업해서 보내준 결과들을 mav 에 잘 넣어서 목적지로 이동만 합니다.
		}
		return mav;
	}

	@RequestMapping("/adminNoticeList")
	public ModelAndView adminNoticeList(HttpServletRequest request) {
	    ModelAndView mav = new ModelAndView();
	    HttpSession session = request.getSession();
	    String id = (String) session.getAttribute("workId");
	    if (id == null) {
	        mav.setViewName("redirect:/admin");
	    } else {
	        HashMap<String, Object> result = as.getNoticeList(request);
	        mav.addObject("noticeList", (List<NoticeVO>) result.get("noticeList"));
	        mav.addObject("paging", (Paging) result.get("paging"));
	        mav.addObject("key", (String) result.get("key"));
	        mav.setViewName("admin/notice/adminNoticeList");
	    }
	    return mav;
	}

	
	@RequestMapping("/adminEventList")
	public ModelAndView adminEventList(HttpServletRequest request) {
	    ModelAndView mav = new ModelAndView();
	    HttpSession session = request.getSession();
	    String id = (String) session.getAttribute("workId");
	    if (id == null) {
	        mav.setViewName("redirect:/admin");
	    } else {
	        HashMap<String, Object> result = as.getEventList(request);
	        mav.addObject("eventList", (List<EventVO>) result.get("eventList"));
	        mav.addObject("paging", (Paging) result.get("paging"));
	        mav.addObject("key", (String) result.get("key"));
	        mav.setViewName("admin/event/adminEventList");
	    }
	    return mav;
	}

	
	@RequestMapping("/adminOrderList")
	public ModelAndView adminOrderList(HttpServletRequest request) {
	    ModelAndView mav = new ModelAndView();
	    HttpSession session = request.getSession();
	    String id = (String) session.getAttribute("workId");
	    if (id == null) {
	        mav.setViewName("redirect:/admin");
	    } else {
	        HashMap<String, Object> result = as.getOrderList(request);
	        mav.addObject("orderList", (List<OrderDetailVO>) result.get("orderList"));
	        mav.addObject("paging", (Paging) result.get("paging"));
	        mav.addObject("key", (String) result.get("key"));
	        mav.setViewName("admin/order/adminOrderList");
	    }
	    return mav;
	}
	
	@RequestMapping("/adminBannerList")
	public ModelAndView adminBannerList( ) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("bannerList", as.getBannerList() );
		mav.setViewName("admin/banner/adminBannerList");
		
		return mav;
	}
	
	@RequestMapping("/newBannerWrite")
	public String newBannerWrite() {
		return "admin/banner/adminBannerWrite";
	}
	
	
	@RequestMapping("/adminBannerWrite" )
	public String adminBannerWrite( HttpServletRequest request ) {
		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("subject", request.getParameter("subject") );
		paramMap.put("order_seq", Integer.parseInt(request.getParameter("order_seq")));
		paramMap.put("btitle", request.getParameter("btitle") );
		paramMap.put("btext", request.getParameter("btext") );
		paramMap.put("top", request.getParameter("top") );
		paramMap.put("left", request.getParameter("left") );
		paramMap.put("video", request.getParameter("video") );
		
		if( request.getParameter("order_seq").equals("6") ) paramMap.put("useyn", "N" );
		else paramMap.put("useyn", "Y" );
		
		as.insertBanner( paramMap );
		return "redirect:/adminBannerList";
	}

	@RequestMapping("/changeOrder")
	public String changeOrder(
			HttpServletRequest request,
			@RequestParam("bseq") int bseq,
			@RequestParam("changeval") int changeval  	) {
		
		String useyn;
		if( changeval > 5) useyn="N";
		else useyn="Y";
		
		as.updateSeq( changeval, useyn, bseq);
		
		return "redirect:/adminBannerList";
	}
	
	@RequestMapping("bannerDelete")
	public String bannerDelete( HttpServletRequest request) {
		int bseq = Integer.parseInt(request.getParameter("bseq"));
		as.deleteBanner(bseq);	
		return "redirect:/adminBannerList";
	}
	
	@RequestMapping("/bannerUpdate")
	public String bannerUpdate(
			HttpServletRequest request,BannerVO bannervo) {
		
		String useyn;
		if( bannervo.getOrder_seq() > 5) useyn="N";
		else useyn="Y";
		
		as.updateBanner( bannervo);
		
		return "redirect:/adminBannerList";
	}
	
	@RequestMapping("bannerUpdateForm")
	   public String bannerUpdateForm(
	               Model model, HttpServletRequest request,
	               BannerVO bannervo) {
		
		if( bannervo.getVideo() == null  || bannervo.getVideo().equals("") )
			bannervo.setVideo( request.getParameter("oldfilename") );
		
		
	      model.addAttribute("bannerVO", as.getBanner(bannervo.getBseq()));
	      return "admin/banner/adminBannerUpdateForm";
	      
	  }
	
	@RequestMapping("adminProductDetail")
	public ModelAndView adminProductDetail(@RequestParam("pseq") int pseq, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> result = ps.getProduct(pseq);
		ProductVO pvo = (ProductVO) result.get("productVO");
		mav.addObject("productVO", pvo);
		mav.setViewName("admin/product/adminProductDetail");
		return mav;
	}

	@RequestMapping("adminProductInsertForm")
	public String adminProductInsertForm() {
		return "admin/product/adminProductInsertForm";
	}

	@RequestMapping("adminProductInsert")
	public String adminProductInsert(Model model ,ProductVO productvo,  HttpServletRequest request) {
		
		as.insertProduct(productvo);
		model.addAttribute("ProductVO", productvo);
	    return "admin/product/productColorInsert";
	}
	
	@RequestMapping("adminProductDelete")
	public String adminProductDelete(HttpServletRequest request) {
		int pseq = Integer.parseInt(request.getParameter("pseq"));
		as.deleteProduct(pseq);
		return "redirect:/adminProductList";
	}
	
	@RequestMapping("adminProductUpdateForm")
	public ModelAndView adminProductUpdateForm(@RequestParam("pseq") int pseq, HttpServletRequest request, Model model) {
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> result = ps.getProduct(pseq);
		ProductVO pvo = (ProductVO)result.get("productVO");
		mav.addObject("ProductVO", pvo);
		mav.setViewName("admin/product/adminProductUpdateForm");
		return mav;
	}
	
	@RequestMapping("adminProductUpdate")
	public String adminProductUpdate(ProductVO pvo, Model model, HttpServletRequest request) {
		String url = "admin/product/adminProductUpdateForm";
		as.updateProduct(pvo);
		url = "redirect:/adminProductDetail?pseq=" + pvo.getPseq();
		return url;
	}
	
	@RequestMapping("adminColorList")
	public ModelAndView adminColorList( @RequestParam("pseq") int pseq) {
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> paramMap = as.getColorList(pseq);
		mav.addObject("ProductColorList", (List<ColorVO>)paramMap.get("ProductColorList"));
		mav.setViewName("admin/product/productColorList");
		return mav;
	}
	
	@RequestMapping("adminColorDetail")
	public ModelAndView adminColorDetail(@RequestParam("cseq") int cseq, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("ColorVO", as.getColor(cseq));
		mav.setViewName("admin/product/productColorDetail");
		return mav;
	}
	
	@RequestMapping("adminColorInsertForm")
	public String adminColorInsertForm(HttpServletRequest request, @RequestParam("pseq") int pseq) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pseq", pseq);
		paramMap.put("name", request.getParameter("name") );
		paramMap.put("ccode", request.getParameter("ccode") );
		paramMap.put("image", request.getParameter("image") );
		if( request.getParameter("image") == null )
			paramMap.put("image", "" );
		else 
			paramMap.put("image", request.getParameter("image") );
		as.insertColor( paramMap );
		return "redirect:/adminProductList";
	}
	
	@RequestMapping("adminColorInsert")
	public String adminColorInsert(HttpServletRequest request, @RequestParam("pseq") int pseq) {
		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pseq", pseq);
		paramMap.put("name", request.getParameter("name") );
		paramMap.put("ccode", request.getParameter("ccode") );
		paramMap.put("image", request.getParameter("image") );
		if( request.getParameter("image") == null )
			paramMap.put("image", "" );
		else 
			paramMap.put("image", request.getParameter("image") );
		as.insertColor( paramMap );
		return "redirect:/adminProductList";
	}
	
	@Autowired
	QnaService qs;
	
	@RequestMapping("/adminQnaDetail")
	public ModelAndView adminQnaDetail( @RequestParam("qseq") int qseq   	) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("qnaVO", qs.getQna(qseq) );
		mav.setViewName("admin/qna/adminQnaDetail");
		return mav;
	}
	
	@RequestMapping("/adminQnaReply")
	public String adminQnaReply( @RequestParam("qseq") int qseq , 
									@RequestParam("reply") String reply ) {
		as.qnaReply( qseq, reply );
		return "redirect:/adminQnaDetail?qseq=" + qseq;
	}
	
	@Autowired
	CommonService cs;
	
	@RequestMapping("/adminNoticeDetail")
	public ModelAndView adminNoticeDetail( @RequestParam("nseq") int nseq   	) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("noticeVO", cs.getNotice(nseq) );
		mav.setViewName("admin/notice/adminNoticeDetail");
		return mav;
	}
	
	@RequestMapping("/adminEventDetail")
	public ModelAndView adminEventDetail( @RequestParam("eseq") int eseq   	) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("eventVO", cs.getEvent(eseq) );
		mav.setViewName("admin/event/adminEventDetail");
		return mav;
	}
	
	@Autowired
	MyPageService mps;
	
	@RequestMapping("/adminOrderDetail")
	public ModelAndView adminOrderDetail( @RequestParam("odseq") int odseq ) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("orderDetailVO", mps.adminOrderDetail(odseq) );
		mav.setViewName("admin/order/adminOrderDetail");
		return mav;
		
}
	
	@RequestMapping("/adminOrderUpdate")
	public String adminOrderUpdate( @RequestParam("result") int results, @RequestParam("odseq") int odseq ) {
		mps.adminOrderUpdate( results,odseq );
		
		return "redirect:/adminOrderList";
	}
	
	
	@RequestMapping("/adminNoticeInsertForm")
	public String adminNoticeInsertForm() {
		return "admin/notice/adminNoticeInsertForm";
	}
	
	@RequestMapping(value="/adminNoticeInsert" , method = RequestMethod.POST)
	public String adminNoticeInsert( NoticeVO noticeVO, HttpServletRequest request) {
		cs.insertNotice( noticeVO );
		return "redirect:/adminNoticeList";
	}
	
	
	
	@RequestMapping("adminNoticeUpdateForm")
	   public String adminNoticeUpdateForm(
	               Model model, HttpServletRequest request,
	              NoticeVO noticevo) {
		
	      model.addAttribute("noticeVO", cs.getNotice(noticevo.getNseq()));
	      return "admin/notice/adminNoticeUpdateForm";
	      
	  }
	
	@RequestMapping("/adminNoticeUpdate")
	public String adminNoticeUpdate(
			HttpServletRequest request,NoticeVO noticeVO) {
		
		cs.updateNotice(noticeVO);
		
		return "redirect:/adminNoticeList";
	}
	
	
	@RequestMapping("/adminNoticeDelete")
	public String adminNoticeDelete(
			HttpServletRequest request, @RequestParam("nseq") int nseq) {
		
		cs.deleteNotice(nseq);
		
		return "redirect:/adminNoticeList";
	}
	
	@RequestMapping("/adminEventInsertForm")
	public String adminEventInsertForm() {
		return "admin/event/adminEventInsertForm";
	}
	
	
	@RequestMapping("adminEventInsert" )
	public String adminEventInsert( EventVO eventvo,  HttpServletRequest request	) {
		System.out.println(eventvo.getSubject());
		System.out.println(eventvo.getImage());
		cs.insertEvent( eventvo );
		return "redirect:/adminEventList";
	}
	
	
	
	@RequestMapping("adminEventUpdateForm")
	   public String adminEventUpdateForm(
	               Model model, HttpServletRequest request,
	               EventVO eventvo) {
	      
		if( eventvo.getImage() == null  || eventvo.getImage().equals("") )
			eventvo.setImage( request.getParameter("oldfilename") );
		
			eventvo=cs.getEvent(eventvo.getEseq());
		
	      model.addAttribute("eseq", eventvo.getEseq() );
	      model.addAttribute("eventVO", eventvo );

	      return "admin/event/adminEventUpdateForm";
	      
	  }
	
	@RequestMapping("/adminEventUpdate")
	public String adminEventUpdate(
			HttpServletRequest request,EventVO eventvo) {
		
		cs.updateEvent( eventvo);
		
		return "redirect:/adminEventList";
	}
	
	
	@RequestMapping("/adminEventDelete")
	public String adminEventDelete(
			HttpServletRequest request, @RequestParam("eseq") int eseq) {
		
		cs.deleteEvent( eseq);
		
		return "redirect:/adminEventList";
	}
	
	@RequestMapping("adminBannerView")
	public ModelAndView adminBannerView( 
			HttpServletRequest request, 
			@RequestParam("bseq") int bseq) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject( "bannerVO",   as.getBanner( bseq ) );
		
		mav.setViewName("admin/banner/adminBannerView");
		
		return mav;
	}

	
}
