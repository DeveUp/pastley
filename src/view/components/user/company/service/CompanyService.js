/**
 * @description - Class CompanyService.
 * @autor - Sergio Stives Barrios Buitrago.
 * @email - sergiobuitrago54@gmail.com || sergiostivesbb@ufps.edu.co.
 * @phone - 311893819 || 3114794520.
 * @version - 1.0.0.
 */
class CompanyService {
    getCompany(){
        return fetch('http://localhost:3000/assets/json/company.json')
        .then(response => response.json());
    }

    getCompanyAccount(){
        return fetch('http://localhost:3000/assets/json/company-account.json')
        .then(response => response.json());
    }

    getCompanySocialMedia(){
        return fetch('http://localhost:3000/assets/json/company-social-media.json')
        .then(response => response.json());
    }
}

/**
 * Export.
 */
export default CompanyService;