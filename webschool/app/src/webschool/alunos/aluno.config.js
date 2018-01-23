import AlunosController from './alunos.controller'
import AlunoCadController from './aluno-cad.controller'

import AlunoService from './aluno.service'

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
          template: require('@views/alunos/alunos.html'),
          url: '/list',
          controller: AlunosController,
          controllerAs: 'vm'
        })
        .state('aluno.new', {
          template: require('@views/alunos/aluno-cad.html'),
          url: '/new',
          controller: AlunoCadController,
          controllerAs: 'vm'
        })
        .state('aluno.edit', {
          template: require('@views/alunos/aluno-cad.html'),
          url: '/{id}',
          controller: AlunoCadController,
          controllerAs: 'vm'
        });
    }];
  };