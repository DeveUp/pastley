/**
 * @description - Class CategoryService.
 * @autor - Sergio Stives Barrios Buitrago.
 * @email - sergiobuitrago54@gmail.com || sergiostivesbb@ufps.edu.co.
 * @phone - 311893819 || 3114794520.
 * @version - 1.0.0.
 */
 class CategoryService {

    getCategoryActive(){
        return fetch('http://localhost:3000/assets/json/category.json')
        .then(response => response.json());
    }
}

/**
 * Export.
 */
export default CategoryService;