package com.pastley.bean.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.pastley.controller.request.BuyRequest;
import com.pastley.controller.request.CategoryRequest;
import com.pastley.controller.request.ContactRequest;
import com.pastley.controller.request.MethodPayRequest;
import com.pastley.controller.request.ProductRequest;
import com.pastley.controller.request.ProviderRequest;
import com.pastley.controller.request.RoleRequest;
import com.pastley.controller.request.SaleRequest;
import com.pastley.controller.request.TypeDocumentRequest;
import com.pastley.controller.request.TypePQRRequest;
import com.pastley.controller.request.UserRequest;
import com.pastley.models.app.DataTableApp;
import com.pastley.models.dto.ExceptionDTO;
import com.pastley.models.model.Buy;
import com.pastley.models.model.Category;
import com.pastley.models.model.Contact;
import com.pastley.models.model.Product;
import com.pastley.models.model.Provider;
import com.pastley.models.model.Role;
import com.pastley.models.model.Sale;
import com.pastley.models.model.TypeDocument;
import com.pastley.models.model.TypePQR;
import com.pastley.models.model.User;
import com.pastley.util.PastleyVariable;
import com.pastley.models.model.MethodPay;

@ManagedBean(name = "table")
@ViewScoped
public class DataTableBean implements Serializable {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataTableBean.class);

	private static final long serialVersionUID = 1L;

	private DataTableApp<Buy> buy;
	private DataTableApp<Provider> provider;
	private DataTableApp<Product> product;
	private DataTableApp<Category> category;
	private DataTableApp<MethodPay> methodPay;
	private DataTableApp<TypePQR> typePqr;
	private DataTableApp<Role> role;
	private DataTableApp<User> customer;
	private DataTableApp<User> cashier;
	private DataTableApp<TypeDocument> typeDocument;
	private DataTableApp<Sale> sale;
	private DataTableApp<Contact> contact;

	@PostConstruct
	public void init() {
		buy = new DataTableApp<>();
		product = new DataTableApp<>();
		provider = new DataTableApp<>();
		category = new DataTableApp<>();
		methodPay = new DataTableApp<>();
		typePqr = new DataTableApp<>();
		role = new DataTableApp<>();
		customer = new DataTableApp<>();
		cashier = new DataTableApp<>();
		typeDocument = new DataTableApp<>();
		sale = new DataTableApp<>();
		contact = new DataTableApp<>();
	}

	public List<Contact> getContactEntity() {
		if (contact == null)
			return new ArrayList<>();
		if (!contact.isRenderizar())
			return contact.getEntity();
		ContactRequest contactRequest = new ContactRequest();
		try {
			contact = new DataTableApp<>(contactRequest.findAll());
		} catch (ExceptionDTO e) {
			LOGGER.error("[getContactEntity()]", e);
			contact.setEntity(new ArrayList<>());
		} finally {
			contact.setRenderizar(false);
		}
		return contact.getEntity();
	}

	public List<Sale> getSaleEntity() {
		if (sale == null)
			return new ArrayList<>();
		if (!sale.isRenderizar())
			return sale.getEntity();
		SaleRequest saleRequest = new SaleRequest();
		try {
			sale = new DataTableApp<>(saleRequest.findAll());
		} catch (ExceptionDTO e) {
			LOGGER.error("[getSaleEntity()]", e);
			sale.setEntity(new ArrayList<>());
		} finally {
			sale.setRenderizar(false);
		}
		return sale.getEntity();
	}

	public List<TypeDocument> getTypeDocumentEntity() {
		if (typeDocument == null)
			return new ArrayList<>();
		if (!typeDocument.isRenderizar())
			return typeDocument.getEntity();
		TypeDocumentRequest typeDocumentRequest = new TypeDocumentRequest();
		try {
			typeDocument = new DataTableApp<>(typeDocumentRequest.findAll());
		} catch (ExceptionDTO e) {
			LOGGER.error("[getTypeDocumentEntity()]", e);
			typeDocument.setEntity(new ArrayList<>());
		} finally {
			typeDocument.setRenderizar(false);
		}
		return typeDocument.getEntity();
	}

	public List<User> getCashierEntity() {
		if (cashier == null)
			return new ArrayList<>();
		if (!cashier.isRenderizar())
			return cashier.getEntity();
		UserRequest userRequest = new UserRequest();
		try {
			cashier = new DataTableApp<>(userRequest.findByRoleAll(PastleyVariable.PASTLEY_USER_CASHIER_ID));
		} catch (ExceptionDTO e) {
			LOGGER.error("[getCashierEntity()]", e);
			cashier.setEntity(new ArrayList<>());
		} finally {
			cashier.setRenderizar(false);
		}
		return cashier.getEntity();
	}

	public List<User> getCustomerEntity() {
		if (customer == null)
			return new ArrayList<>();
		if (!customer.isRenderizar())
			return customer.getEntity();
		UserRequest userRequest = new UserRequest();
		try {
			customer = new DataTableApp<>(userRequest.findByRoleAll(PastleyVariable.PASTLEY_USER_CUSTOMER_ID));
		} catch (ExceptionDTO e) {
			LOGGER.error("[getCustomerEntity()]", e);
			customer.setEntity(new ArrayList<>());
		} finally {
			customer.setRenderizar(false);
		}
		return customer.getEntity();
	}

	public List<Role> getRoleEntity() {
		if (role == null)
			return new ArrayList<>();
		if (!role.isRenderizar())
			return role.getEntity();
		RoleRequest roleRequest = new RoleRequest();
		try {
			role = new DataTableApp<>(roleRequest.findAll());
		} catch (ExceptionDTO e) {
			LOGGER.error("[getRoleEntity()]", e);
			role.setEntity(new ArrayList<>());
		} finally {
			role.setRenderizar(false);
		}
		return role.getEntity();
	}

	public List<TypePQR> getTypePqrEntity() {
		if (typePqr == null)
			return new ArrayList<>();
		if (!typePqr.isRenderizar())
			return typePqr.getEntity();
		TypePQRRequest typePQRRequest = new TypePQRRequest();
		try {
			typePqr = new DataTableApp<>(typePQRRequest.findAll());
		} catch (ExceptionDTO e) {
			LOGGER.error("[getTypePqrEntity()]", e);
			typePqr.setEntity(new ArrayList<>());
		} finally {
			typePqr.setRenderizar(false);
		}
		return typePqr.getEntity();
	}

	public List<MethodPay> getMethodPayEntity() {
		if (methodPay == null)
			return new ArrayList<>();
		if (!methodPay.isRenderizar())
			return methodPay.getEntity();
		MethodPayRequest methodPayRequest = new MethodPayRequest();
		try {
			List<MethodPay> list = methodPayRequest.findAll();
			methodPay = new DataTableApp<>(list);
		} catch (ExceptionDTO e) {
			LOGGER.error("[getMethodPayEntity()]", e);
			methodPay.setEntity(new ArrayList<>());
		} finally {
			methodPay.setRenderizar(false);
		}
		return methodPay.getEntity();
	}

	public List<Category> getCategoryEntity() {
		if (category == null)
			return new ArrayList<>();
		if (!category.isRenderizar())
			return category.getEntity();
		CategoryRequest request = new CategoryRequest();
		try {
			category = new DataTableApp<>(request.findAll());
		} catch (ExceptionDTO e) {
			LOGGER.error("[getCategoryEntity()]", e);
			category.setEntity(new ArrayList<>());
		} finally {
			category.setRenderizar(false);
		}
		return category.getEntity();
	}

	public List<Buy> getBuyEntity() {
		if (buy == null)
			return new ArrayList<>();
		if (!buy.isRenderizar())
			return buy.getEntity();
		BuyRequest request = new BuyRequest();
		try {
			buy = new DataTableApp<>(request.findAll());
		} catch (ExceptionDTO e) {
			LOGGER.error("[getBuyEntity()]", e);
			buy.setEntity(new ArrayList<>());
		} finally {
			buy.setRenderizar(false);
		}
		return buy.getEntity();
	}

	public List<Product> getProductEntity() {
		if (product == null)
			return new ArrayList<>();
		if (!product.isRenderizar())
			return product.getEntity();
		ProductRequest request = new ProductRequest();
		try {
			product = new DataTableApp<>(request.findAll());
		} catch (ExceptionDTO e) {
			LOGGER.error("[getProductEntity()]", e);
			product.setEntity(new ArrayList<>());
		} finally {
			product.setRenderizar(false);
		}
		return product.getEntity();
	}

	public List<Provider> getProviderEntity() {
		if (provider == null)
			return new ArrayList<>();
		if (!provider.isRenderizar())
			return provider.getEntity();
		ProviderRequest requestProvider = new ProviderRequest();
		try {
			provider = new DataTableApp<>(requestProvider.findAll());
		} catch (ExceptionDTO e) {
			LOGGER.error("[getProviderEntity()]", e);
			provider.setEntity(new ArrayList<>());
		} finally {
			provider.setRenderizar(false);
		}
		return provider.getEntity();
	}

	public DataTableApp<Buy> cashier() {
		return buy;
	}

	public void setBuy(DataTableApp<Buy> buy) {
		this.buy = buy;
	}

	public DataTableApp<Product> getProduct() {
		return product;
	}

	public void setProduct(DataTableApp<Product> product) {
		this.product = product;
	}

	public DataTableApp<Provider> getProvider() {
		return provider;
	}

	public void setProvider(DataTableApp<Provider> provider) {
		this.provider = provider;
	}

	public DataTableApp<Category> getCategory() {
		return category;
	}

	public void setCategory(DataTableApp<Category> category) {
		this.category = category;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

	public DataTableApp<MethodPay> getMethodPay() {
		return methodPay;
	}

	public void setMethodPay(DataTableApp<MethodPay> methodPay) {
		this.methodPay = methodPay;
	}

	public DataTableApp<TypePQR> getTypePqr() {
		return typePqr;
	}

	public void setTypePqr(DataTableApp<TypePQR> typePqr) {
		this.typePqr = typePqr;
	}

	public DataTableApp<Role> getRole() {
		return role;
	}

	public void setRole(DataTableApp<Role> role) {
		this.role = role;
	}

	public DataTableApp<User> getCustomer() {
		return customer;
	}

	public void setCustomer(DataTableApp<User> customer) {
		this.customer = customer;
	}

	public DataTableApp<User> getCashier() {
		return cashier;
	}

	public void setCashier(DataTableApp<User> cashier) {
		this.cashier = cashier;
	}

	public DataTableApp<TypeDocument> getTypeDocument() {
		return typeDocument;
	}

	public void setTypeDocument(DataTableApp<TypeDocument> typeDocument) {
		this.typeDocument = typeDocument;
	}

	public DataTableApp<Sale> getSale() {
		return sale;
	}

	public void setSale(DataTableApp<Sale> sale) {
		this.sale = sale;
	}

	public DataTableApp<Buy> getBuy() {
		return buy;
	}

	public DataTableApp<Contact> getContact() {
		return contact;
	}

	public void setContact(DataTableApp<Contact> contact) {
		this.contact = contact;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
