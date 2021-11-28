package com.pastley.models.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import com.pastley.util.PastleyValidate;

public class AlertApp implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<FacesMessage> messages;
	private boolean next;
	private int count;
	private int size;

	public AlertApp() {
		init();
	}

	public void init() {
		initMessages();
		next = false;
	}

	public void initMessages() {
		messages = new ArrayList<>();
		count = -1;
		size = -1;
	}

	public void isMessages() {
		if (!PastleyValidate.isList(messages))
			initMessages();
	}

	public boolean containsMessages() {
		return (PastleyValidate.isList(messages));
	}


	public boolean insert(Severity type, String title, String description) {
		isMessages();
		if (type != null && title != null && PastleyValidate.isChain(description)) {
			messages.add(new FacesMessage(type, title, description));
			return true;
		}
		return false;
	}

	public boolean add(AlertApp alert) {
		return (alert != null) ? add(alert.getMessages()) : false;
	}

	public boolean add(List<FacesMessage> list) {
		if (list != null) {
			isMessages();
			int size = list.size();
			int count = 0;
			for (FacesMessage mg : list) {
				if (mg != null) {
					messages.add(mg);
					count++;
				}
			}
			if (count == size)
				return true;
		}
		return false;
	}

	public boolean success(String description) {
		return insert(FacesMessage.SEVERITY_INFO, "", description);
	}

	public boolean warn(String description) {
		return insert(FacesMessage.SEVERITY_WARN, "", description);
	}

	public boolean error(String description) {
		return insert(FacesMessage.SEVERITY_ERROR, "", description);
	}

	public boolean fatal(String description) {
		return insert(FacesMessage.SEVERITY_FATAL, "", description);
	}

	public void toPrintln(List<FacesMessage> list) {
		if(!PastleyValidate.isList(list))
			return;
		for (FacesMessage mg : list)
			toPrintln(mg);
	}

	public void toPrintln(FacesMessage message) {
		if (message != null)
			FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void toPrintln(boolean init) {
		toPrintln(messages);
		if (init)
			initMessages();
	}

	public List<FacesMessage> getMessages() {
		return messages;
	}

	public void setMessages(List<FacesMessage> messages) {
		this.messages = messages;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
