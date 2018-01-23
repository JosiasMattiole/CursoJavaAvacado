import AbstractService from "../abstract/abstract.service";

export default class AlunoService extends AbstractService {

  constructor($http) {
    super($http, 'http://localhost:8080/webschool-web/api/alunos')
  };
};

AlunoService.$inject = ['$http'];
