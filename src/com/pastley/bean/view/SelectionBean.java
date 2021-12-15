package com.pastley.bean.view;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pastley.controller.request.CategoryRequest;
import com.pastley.controller.request.MethodPayRequest;
import com.pastley.controller.request.RoleRequest;
import com.pastley.controller.request.TypeDocumentRequest;
import com.pastley.controller.request.TypePQRRequest;
import com.pastley.models.dto.ExceptionDTO;
import com.pastley.models.model.Category;
import com.pastley.models.model.MethodPay;
import com.pastley.models.model.Role;
import com.pastley.models.model.TypeDocument;
import com.pastley.models.model.TypePQR;
import com.pastley.util.PastleyValidate;

@ManagedBean(name = "selection")
@ViewScoped
public class SelectionBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(SelectionBean.class);

	private List<SelectItem> category;
	private boolean renderizarCategory;

	private List<SelectItem> pqr;
	private boolean renderizarPqr;

	private List<SelectItem> role;
	private boolean renderizarRole;

	private List<SelectItem> typeDocument;
	private boolean renderizartypeDocument;

	private List<SelectItem> methodPay;
	private boolean renderizarMethodPay;

	public SelectionBean() {
		init();
	}

	@PostConstruct
	public void init() {
		renderizarCategory = true;
		renderizarPqr = true;
		renderizarRole = true;
		renderizartypeDocument = true;
		renderizarMethodPay = true;
	}

	public List<SelectItem> getCategory() {
		if (renderizarCategory) {
			this.category = new ArrayList<>();
			SelectItemGroup group = new SelectItemGroup("No se ha encontrado ninguna categoria.");
			try {
				CategoryRequest categoryRequest = new CategoryRequest();
				List<Category> list = categoryRequest.findByStatuAll(true);
				if (!PastleyValidate.isList(list)) {
					group.setSelectItems(new SelectItem[0]);
				} else {
					group = new SelectItemGroup("Categorias");
					int i = 0;
					SelectItem[] items = new SelectItem[list.size()];
					for (Category category : list) {
						items[i] = new SelectItem(String.valueOf(category.getId()), category.getName());
						i++;
					}
					group.setSelectItems(items);
				}
			} catch (ExceptionDTO e) {
				LOGGER.error("[getCategory()]", e);
				group.setSelectItems(new SelectItem[0]);
			} finally {
				category.add(group);
				renderizarCategory = false;
			}
		}
		return category;
	}

	public List<SelectItem> getPqr() {
		if (renderizarPqr) {
			this.pqr = new ArrayList<>();
			SelectItemGroup group = new SelectItemGroup("No se ha encontrado ninguna pqr.");
			try {
				TypePQRRequest typePQRRequest = new TypePQRRequest();
				List<TypePQR> list = typePQRRequest.findByStatuAll(true);
				if (!PastleyValidate.isList(list)) {
					group.setSelectItems(new SelectItem[0]);
				} else {
					group = new SelectItemGroup("PQR");
					int i = 0;
					SelectItem[] items = new SelectItem[list.size()];
					for (TypePQR type : list) {
						items[i] = new SelectItem(String.valueOf(type.getId()), type.getName());
						i++;
					}
				}
			} catch (ExceptionDTO e) {
				LOGGER.error("[getPqr()]", e);
				group.setSelectItems(new SelectItem[0]);
			} finally {
				pqr.add(group);
				renderizarPqr = false;
			}
		}
		return pqr;
	}

	public List<SelectItem> getRole() {
		if (renderizarRole) {
			this.role = new ArrayList<>();
			SelectItemGroup group = new SelectItemGroup("No se ha encontrado ningun rol.");
			try {
				RoleRequest roleRequest = new RoleRequest();
				List<Role> list = roleRequest.findByStatuAll(true);
				if (!PastleyValidate.isList(list)) {
					group.setSelectItems(new SelectItem[0]);
				} else {
					group = new SelectItemGroup("Rol");
					int i = 0;
					SelectItem[] items = new SelectItem[list.size()];
					for (Role role : list) {
						items[i] = new SelectItem(String.valueOf(role.getId()), role.getName());
						i++;
					}
				}
			} catch (ExceptionDTO e) {
				LOGGER.error("[getRole()]", e);
				group.setSelectItems(new SelectItem[0]);
			} finally {
				role.add(group);
				renderizarRole = false;
			}
		}
		return role;
	}

	public List<SelectItem> getTypeDocument() {
		if (renderizartypeDocument) {
			this.typeDocument = new ArrayList<>();
			SelectItemGroup group = new SelectItemGroup("No se ha encontrado ningun tipo de documento.");
			try {
				TypeDocumentRequest typeDocumentRequest = new TypeDocumentRequest();
				List<TypeDocument> list = typeDocumentRequest.findByStatuAll(true);
				if (!PastleyValidate.isList(list)) {
					group.setSelectItems(new SelectItem[0]);
				} else {
					group = new SelectItemGroup("Tipo Documento");
					int i = 0;
					SelectItem[] items = new SelectItem[list.size()];
					for (TypeDocument type : list) {
						items[i] = new SelectItem(String.valueOf(type.getId()), type.getName());
						i++;
					}
				}
			} catch (ExceptionDTO e) {
				LOGGER.error("[getTypeDocument()]", e);
				group.setSelectItems(new SelectItem[0]);
			} finally {
				typeDocument.add(group);
				renderizartypeDocument = false;
			}
		}
		return typeDocument;
	}

	public List<SelectItem> getMethodPay() {
		if (renderizarMethodPay) {
			this.methodPay = new ArrayList<>();
			SelectItemGroup group = new SelectItemGroup("No se ha encontrado ningun metodo de pago.");
			try {
				MethodPayRequest methodPayRequest = new MethodPayRequest();
				List<MethodPay> list = methodPayRequest.findByStatuAll(true);
				if (!PastleyValidate.isList(list)) {
					group.setSelectItems(new SelectItem[0]);
				} else {
					group = new SelectItemGroup("Metodo de pago");
					int i = 0;
					SelectItem[] items = new SelectItem[list.size()];
					for (MethodPay method : list) {
						items[i] = new SelectItem(String.valueOf(method.getId()), method.getName());
						i++;
					}
				}
			} catch (ExceptionDTO e) {
				LOGGER.error("[getMethodPay()]", e);
				group.setSelectItems(new SelectItem[0]);
			} finally {
				methodPay.add(group);
				renderizarMethodPay = false;
			}
		}
		return methodPay;
	}

	public void setMethodPay(List<SelectItem> methodPay) {
		this.methodPay = methodPay;
	}

	public boolean isRenderizarMethodPay() {
		return renderizarMethodPay;
	}

	public void setRenderizarMethodPay(boolean renderizarMethodPay) {
		this.renderizarMethodPay = renderizarMethodPay;
	}

	public void setRole(List<SelectItem> role) {
		this.role = role;
	}

	public boolean isRenderizarRole() {
		return renderizarRole;
	}

	public void setRenderizarRole(boolean renderizarRole) {
		this.renderizarRole = renderizarRole;
	}

	public void setTypeDocument(List<SelectItem> typeDocument) {
		this.typeDocument = typeDocument;
	}

	public boolean isRenderizartypeDocument() {
		return renderizartypeDocument;
	}

	public void setRenderizartypeDocument(boolean renderizartypeDocument) {
		this.renderizartypeDocument = renderizartypeDocument;
	}

	public void setCategory(List<SelectItem> category) {
		this.category = category;
	}

	public void setPqr(List<SelectItem> pqr) {
		this.pqr = pqr;
	}

	public boolean isRenderizarPqr() {
		return renderizarPqr;
	}

	public void setRenderizarPqr(boolean renderizarPqr) {
		this.renderizarPqr = renderizarPqr;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

	public boolean isRenderizarCategory() {
		return renderizarCategory;
	}

	public void setRenderizarCategory(boolean renderizarCategory) {
		this.renderizarCategory = renderizarCategory;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
