import AbstractService from "../abstract/abstract.service";

export default class TurmaService extends AbstractService {

  constructor($http) {
    super($http, 'http://localhost:8080/webschool-web/api/turmas')
  };
};

TurmaService.$inject = ['$http'];
