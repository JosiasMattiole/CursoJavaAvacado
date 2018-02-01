import TurmasController from './turmas.controller'
import TurmaCadController from './turma-cad.controller'

import TurmaService from './turma.service'

export const turmaConfig = (modulo) => {
  modulo.service('TurmaService', TurmaService);

  return ['$stateProvider', '$urlRouterProvider',
    ($stateProvider, $urlRouterProvider) => {
      $stateProvider
        .state('turma', {
          template: require('@views/default.html'),
          url: '/turmas',
          onEnter: ['$state', function ($state) {
            $state.go('turma.list')
          }]
        })
        .state('turma.list', {
          template: require('@views/turmas/turmas.html'),
          url: '/list',
          controller: TurmasController,
          controllerAs: 'vm'
        })
        .state('turma.new', {
          template: require('@views/turmas/turma-cad.html'),
          url: '/new',
          controller: TurmaCadController,
          controllerAs: 'vm'
        })
        .state('turma.edit', {
          template: require('@views/turmas/turma-cad.html'),
          url: '/{id}',
          controller: TurmaCadController,
          controllerAs: 'vm'
        });
    }];
  };