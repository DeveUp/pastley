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
import com.pastley.models.dto.ExceptionDTO;
import com.pastley.models.model.Category;
import com.pastley.util.PastleyValidate;

@ManagedBean(name = "selection")
@ViewScoped
public class SelectionBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(SelectionBean.class);

	private List<SelectItem> category;
	private boolean renderizarCategory;

	public SelectionBean(){
		init();
	}
	
	@PostConstruct
	public void init() {
		renderizarCategory = true;
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

	public void setCategory(List<SelectItem> category) {
		this.category = category;
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
