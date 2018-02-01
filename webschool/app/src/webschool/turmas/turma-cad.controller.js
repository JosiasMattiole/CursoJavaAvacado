export default class TurmaCadController {
    
    constructor($stateParams, $state, TurmaService) {
        this.record = {};
        this.title = 'Adicionando turma';
        this._service = TurmaService;
    
        if ($stateParams.id) {
            this.title = 'Editando turma';
            this._service.findById($stateParams.id)
                .then(data => {
                    this.record = data
                })
        };
        this._state = $state;
    };
    
    save() {
        this._service.save(this.record)
            .then(resp => {
                this._state.go('turma.list')
            })
            .catch(error => {
                console.log(error)
            });
    };
};
    
TurmaCadController.$inject = ['$stateParams', '$state', 'TurmaService'];
    