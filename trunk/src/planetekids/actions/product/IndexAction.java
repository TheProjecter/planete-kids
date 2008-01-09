package planetekids.actions.product;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.axis.wsdl.symbolTable.Parameters;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.SessionAware;
import planetekids.beans.entity.ProductBean;
import planetekids.beans.stateful.CustomerBean;
import planetekids.beans.stateful.CustomerRemote;

public class IndexAction extends ActionSupport implements SessionAware, ParameterAware {
    
    static int PAGESIZE = 8;
    static int PAGENB = 6;
    private Map session;
    private Map parameters;
    
    private int page;
    private List<Integer> ageFilter;
    private List<Integer> categoryFilter;
    private List<Integer> labelFilter;
    private List<Integer> colorFilter;
    private boolean and;
    private int nbpage;
    private List<ProductBean> products;
    
    public void setSession(Map session) {
        this.session = session;
    }
    
    public void setParameters(Map parameters) {
        this.parameters = parameters;
    }
    
    public CustomerRemote getCustomer() {
        return (CustomerRemote)session.get("customer");
    }
    
    @Override
    public String execute() throws Exception {
        try {
            if(getCustomer() == null) session.put("customer", new InitialContext().lookup(CustomerBean.class.getName() + "_" + CustomerRemote.class.getName() + "@Remote"));
            ageFilter = new ArrayList<Integer>();
            categoryFilter = new ArrayList<Integer>();
            labelFilter = new ArrayList<Integer>();
            colorFilter = new ArrayList<Integer>();
            and = false;
            
            if (parameters.get("ageFilter") != null) {
                try {
                    String[] ages = ((String[])parameters.get("ageFilter"))[0].split(",");
                    for (int i = 0; i < ages.length; i++) {
                        ageFilter.add(new Integer(ages[i]));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (parameters.get("categoryFilter") != null) {
                try {
                    String[] categories = ((String[])parameters.get("categoryFilter"))[0].split(",");
                    for (int i = 0; i < categories.length; i++) {
                        categoryFilter.add(new Integer(categories[i]));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (parameters.get("labelFilter") != null) {
                try {
                    String[] labels = ((String[])parameters.get("labelFilter"))[0].split(",");
                    for (int i = 0; i < labels.length; i++) {
                        labelFilter.add(new Integer(labels[i]));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (parameters.get("colorFilter") != null) {
                try {
                    String[] colors = ((String[])parameters.get("colorFilter"))[0].split(",");
                    for (int i = 0; i < colors.length; i++) {
                        colorFilter.add(new Integer(colors[i]));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (parameters.get("and") != null) {
                try {
                    and = new Boolean(((String[])parameters.get("and"))[0]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            
            if (ageFilter.size() == 0 && labelFilter.size() == 0 && categoryFilter.size() == 0 && colorFilter.size() == 0) {
                products = getCustomer().getProducts();
            } else {
                products = getCustomer().getProductsByFilter(categoryFilter, colorFilter, labelFilter, ageFilter, and);
            }
            
            
            page = 1;
            nbpage = products.size() / PAGESIZE + 1;
            if (parameters.get("page") != null) {
                try {
                    page = new Integer(((String[])parameters.get("page"))[0]).intValue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (page < 1) page = 1;
            if (page > nbpage) page = nbpage;
            
            return ActionSupport.SUCCESS;
        } catch (NamingException ex) {
            return ActionSupport.ERROR;
        }
    }
    
    public String getAgeFilter() {
        return ((String[])parameters.get("ageFilter"))[0];
    }
    
    public String getCategoryFilter() {
        return ((String[])parameters.get("categoryFilter"))[0];
    }
    
    public String getColorFilter() {
        return ((String[])parameters.get("colorFilter"))[0];
    }
    
    public String getLabelFilter() {
        return ((String[])parameters.get("labelFilter"))[0];
    }
    
    public String getAndFilter() {
        return ((String[])parameters.get("and"))[0];
    }
    
    public String redirect() throws Exception {
        session.put("content_action", "index_content");
        session.put("content_namespace", "/product");
        session.put("location_action", "index_location");
        session.put("location_namespace", "/product");
        session.put("parameters", parameters);
        return execute();
    }
    
    public String content() throws Exception {
        if (session.get("parameters") != null) parameters = (Map)session.remove("parameters");
        return execute();
    }
    
    public List<ProductBean> getProducts() throws Exception {
        int lastElement = page * PAGESIZE;
        if (lastElement > products.size())
            lastElement = products.size();
        return products.subList((page - 1) * PAGESIZE, lastElement);
    }
    
    public ProductBean getProduct(int id) throws Exception {
        return getCustomer().getProduct(id);
    }
    
    public int getPage() throws Exception {
        return page;
    }
    
    public int getNbPage() throws Exception {
        return nbpage;
    }
    
    public List<Integer> getPages() throws Exception {
        List<Integer> pages = new ArrayList<Integer>();
        int first = page - PAGENB / 2;
        int last = first + PAGENB - 1;
        if(first < 1) {
            last += 1 - first;
            first = 1;
        }
        if(last > nbpage) {
            first -= last - nbpage;
            last = nbpage;
        }
        if(first < 1) first = 1;
        
        for(int i=first;i<=last;i++) {
            pages.add(new Integer(i));
        }
        return pages;
    }
}
