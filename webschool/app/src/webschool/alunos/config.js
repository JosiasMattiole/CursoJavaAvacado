import ListController from './list.controller'
import FormController from './form.controller'

import AlunoService from './alunoService'

export const alunoConfig = (modulo) => {
  modulo.service('AlunoService', AlunoService);

  return ['$stateProvider', '$urlRouterProvider',
    ($stateProvider, $urlRouterProvider) => {
      $stateProvider
        .state('aluno', {
          template: require('@views/default.html'),
          url: '/alunos',
          onEnter: ['$state', function ($state) {
            $state.go('aluno.list')
          }]
        })
        .state('aluno.list', {
          template: require('@views/alunos/list.html'),
          url: '/list',
          controller: ListController,
          controllerAs: 'vm'
        })
        .state('aluno.new', {
          template: require('@views/alunos/form.html'),
          url: '/new',
          controller: FormController,
          controllerAs: 'vm'
        })
        .state('aluno.edit', {
          template: require('@views/alunos/form.html'),
          url: '/{id}',
          controller: FormController,
          controllerAs: 'vm'
        });
    }];
  };