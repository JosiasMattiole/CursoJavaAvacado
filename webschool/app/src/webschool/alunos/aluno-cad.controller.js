export default class AlunoCadController {

    constructor($stateParams, $state, AlunoService) {
        this.record = {};
        this.title = 'Adicionando aluno';
        this._service = AlunoService;

        if ($stateParams.id) {
            this.title = 'Editando aluno';
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
                this._state.go('aluno.list')
            })
            .catch(error => {
                console.log(error)
            });
    };
};

AlunoCadController.$inject = ['$stateParams', '$state', 'AlunoService'];
