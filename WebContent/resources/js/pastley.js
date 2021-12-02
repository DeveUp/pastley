// Class
const LSY_CLASS_ACTIVE = "lsy-option-active";
const LSY_CLASS_HOVER = "lsy-option-hover";
// Object
const LSY_OBJECT_FLIP = {
    "a": "lsy-animation-flip-10",
    "b": "lsy-animation-flip90",
    "c": "lsy-animation-flip190",
    "d": "lsy-animation-flip180",
}

const pastleyGenericClassRemove = (elements, className = LSY_CLASS_ACTIVE) => {
	if(elements != null){
		elements.forEach(e => {
			e.classList.remove(`${className}`);
		});
	}
}

const pastleyAnimationFlip = (element, fuctionExecute, flip = LSY_OBJECT_FLIP) => { 
	element.classList.add(flip.a); 
	setTimeout(function () {  
		element.classList.remove(flip.a); 
		element.classList.add(flip.b); 
	}, 50);  
	setTimeout(function () { 
		element.classList.remove(flip.b); 
		element.classList.add(flip.c); 
		setTimeout(function () { 
			element.classList.remove(flip.c); 
			element.classList.add(flip.d);  
			setTimeout(function () { 
				element.classList.remove(flip.d); 
				fuctionExecute(); 
			}, 200); 
		}, 100);  
	}, 150); 
}

const pastleyMenuHome = (id) => {
	let drop = document.querySelector(`${id} .lsy-menu-home-link__drop`);
	let btnMenuClose = document.querySelector(`${id} .lsy-btn-close`);
	let grid= document.querySelector(`${id} .lsy-menu-home-container__grid`);
	let link = document.querySelector(`${id} .lsy-menu-home-link`);
	let products = document.querySelector(`${id} .lsy-menu-home-container__grid-products`);
	let isMovil = () => window.innerWidth <= 800;
	
	if(drop != null){
		drop.addEventListener('mouseover', () => {
			if(!isMovil()){
				grid.classList.add(LSY_CLASS_ACTIVE);
			}
		});
		
		grid.addEventListener('mouseleave', () => {
			if(!isMovil()){
				grid.classList.remove(LSY_CLASS_ACTIVE);
			}	
		});
		
		document.querySelectorAll(`${id} .lsy-menu-home-container__grid-categories a`).forEach((element) => {
			element.addEventListener('mouseenter', (e) => {
				if(!isMovil()){
					document.querySelectorAll(`${id} .lsy-menu-home-container__grid-products-product`).forEach((c) => {
						c.classList.remove(LSY_CLASS_ACTIVE);
						if(c.dataset.categoria === e.target.dataset.categoria){
							c.classList.add(LSY_CLASS_ACTIVE);
						}
					});
				}
			});
		});
		
		document.querySelector(`${id} .lsy-btn-bars`).addEventListener('click', (e) => {
			e.preventDefault();
			if(link.classList.contains(LSY_CLASS_ACTIVE)){
				link.classList.remove(LSY_CLASS_ACTIVE);
				document.querySelector('body').style.overflow = 'visible';
			} else {
				link.classList.add(LSY_CLASS_ACTIVE);
				document.querySelector('body').style.overflow = 'hidden';
			}
		});
		
		drop.addEventListener('click', (e) => {
			e.preventDefault();
			grid.classList.add(LSY_CLASS_ACTIVE);
			btnMenuClose.classList.add(LSY_CLASS_ACTIVE);
		});
		
		document.querySelector(`${id} .lsy-menu-home-container__grid-categories .lsy-btn-before`).addEventListener('click', (e) => {
			e.preventDefault();
			grid.classList.remove(LSY_CLASS_ACTIVE);
			btnMenuClose.classList.remove(LSY_CLASS_ACTIVE);
		});
		
		document.querySelectorAll(`${id} .lsy-menu-home-container__grid-categories a`).forEach((elemento) => {
			elemento.addEventListener('click', (e) => {
				if(isMovil()){
					products.classList.add(LSY_CLASS_ACTIVE);
					document.querySelectorAll(`${id} .lsy-menu-home-container__grid-products-product`).forEach((c) => {
						c.classList.remove(LSY_CLASS_ACTIVE);
						if(c.dataset.categoria == e.target.dataset.categoria){
							c.classList.add(LSY_CLASS_ACTIVE);
						}
					});
				}
			});
		});
		
		document.querySelectorAll(`${id} .lsy-menu-home-container__grid-products-product .lsy-btn-before`).forEach((btn) => {
			btn.addEventListener('click', (e) => {
				e.preventDefault();
				products.classList.remove(LSY_CLASS_ACTIVE);
			});
		});
		
		btnMenuClose.addEventListener('click', (e)=> {
			e.preventDefault();
			document.querySelectorAll(`${id} .${LSY_CLASS_ACTIVE}`).forEach((elemento) => {
				elemento.classList.remove(LSY_CLASS_ACTIVE);
			});
			document.querySelector('body').style.overflow = 'visible';
		});
	}
}

const pastleyMenuLeft = (id) =>{
	let menu = document.querySelector(`${id}`);
	if(menu != null){
		let items = menu.querySelectorAll(".lsy-menu-user-left__item-accordion > a");
		if(items != null){
			items.forEach((e) => {
				e.addEventListener("click", (ev) => {
					ev.preventDefault();
					let parent = e.parentNode;
					if(parent != null){
						let ul = parent.querySelector("UL");
						parent.classList.toggle(LSY_CLASS_ACTIVE);
						if(ul != null){
							ul.classList.toggle(LSY_CLASS_ACTIVE);
						}
					}
				});
			});
		}
	}
}

const pastleyKnowUs = (id) => {
	let know = document.querySelector(`${id}`);
	if(know != null){
		const add = (position, info, items) => {
			pastleyGenericClassRemove(info);
			pastleyGenericClassRemove(items);
			items[position].classList.add(`${LSY_CLASS_ACTIVE}`);
			info[position].classList.add(`${LSY_CLASS_ACTIVE}`);
		}
		let info = know.querySelectorAll(`.lsy-interface-know__content-info`);
		let navItem = know.querySelectorAll(`.lsy-interface-know__nav-item`);
		if(navItem != null){
			navItem.forEach((e, i) => {
				e.addEventListener("click", (ev) => {
					ev.preventDefault();
					add(i, info, navItem);
				});
			});
			add(0, info, navItem);
		}
	}
}

const pastleyCardProduct = (id) => {
	let card = document.querySelectorAll(`${id}`);
	if(card != null){
		let cardView = "lsy-card__product-view";
		let cardLarge = "lsy-card__product-large";
		card.forEach((ae) => {
			let buttonOpen = ae.querySelector(`.lsy-card__product-button-open`);
			let buttonClose = ae.querySelector(`.lsy-card__product-close`);
			let buttonLarge = ae.querySelector(`.lsy-card__product-button-large`);
			
			let buttons = ae.querySelector(`.lsy-card__product-button`);
			let description = ae.querySelector(`.lsy-card__product-description`);
			
			ae.addEventListener("mouseover", (e) => {
				e.preventDefault();
				if(!ae.classList.contains(`${cardLarge}`)){
					ae.classList.add(`${LSY_CLASS_HOVER}`);
				}
			});
			// HOVER
			ae.addEventListener("mouseout", (e) => {
				e.preventDefault();
				if(!ae.classList.contains(`${cardLarge}`)){
					ae.classList.remove(`${LSY_CLASS_HOVER}`);
				}
			});
			// VIEW
			if(buttonOpen != null){
				buttonOpen.addEventListener("click", (e) => {
					e.preventDefault();
					if(!ae.classList.contains(`${cardLarge}`)){
						pastleyAnimationFlip(ae, () =>{
							ae.classList.add(`${cardView}`);
							if(buttons != null){
								buttons.removeAttribute("style");
							}
							if(description != null){
								description.removeAttribute("style");
							}
						});
					}
				});
			}
			if(buttonClose != null){
				buttonClose.addEventListener("click", (e) => {
					e.preventDefault();
					if(!ae.classList.contains(`${cardLarge}`)){
						pastleyAnimationFlip(ae, () =>{
							ae.classList.remove(`${cardView}`);
							ae.classList.remove(`${LSY_CLASS_HOVER}`);
						});
					}
				});
			}
			// LARGE
			if(buttonLarge != null){
				buttonLarge.addEventListener("click", (e) => {
					e.preventDefault();
					ae.classList.toggle(`${cardLarge}`);
					ae.classList.remove(`${LSY_CLASS_HOVER}`);
					ae.classList.remove(`${cardView}`);
					if(!ae.classList.contains(`${cardLarge}`)){
						if(buttons != null){
							buttons.style.display = "none";
						}
						if(description != null){
							description.style.display = "none";
						}
						setTimeout(() => {
							if(buttons != null){
								buttons.style.display = "flex";
							}
							if(description != null){
								description.style.display = "block";
							}
						}, 500);
					}else{
						if(buttons != null){
							buttons.style.display = "none";
						}
						setTimeout(() => {
							if(buttons != null){
								buttons.style.display = "flex";
							}
						}, 500);
					}
				});
			}
		});
	}
}