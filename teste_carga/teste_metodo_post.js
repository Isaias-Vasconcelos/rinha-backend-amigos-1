import http from "k6/http"
import { check } from "k6"

export let options = {
  stages: [
    { duration: '3s', target: 1 },
    { duration: '10s', target: 40 },
    { duration: '30s', target: 80 },
    { duration: '10s', target: 2 },
    { duration: '5s', target: 50 },
    { duration: '10s', target: 100 },
    { duration: '2s', target: 1 },
    { duration: '20s', target: 200 }

  ],
  thresholds: {
    http_req_failed: ['rate < 0.02'],
    http_req_duration: ['p(95) < 200']
  }
}

const nomes = ["Ana", "Bruno", "Carlos", "Diana", "Eduardo", "Fernanda", "Gustavo", "Helena", "Igor", "Julia"];

const sobrenomes = ["Silva", "Santos", "Pereira", "Oliveira", "Souza", "Ferreira", "Almeida", "Rodrigues", "Costa", "Carvalho"];

const roupas = ["Camiseta", "Camisa", "Blusa", "Regata", "Polo", "Suéter", "Jaqueta", "Casaco", "Moletom", "Blazer", "Paletó",
   "Colete", "Cardigan", "Calça", "Jeans", "Calça social", "Bermuda", "Shorts", "Saia", "Vestido",
  "Macacão", "Macacão curto", "Terno", "Gravata", "Lenço", "Cachecol", "Meias", "Sapatos", "Tênis", "Botas", "Sandálias",
  "Chinelo", "Boné", "Chapéu", "Luvas", "Cinto", "Pijama", "Roupão", "Lingerie", "Cueca", "Sutiã", "Calcinha", "Biquíni", "Maiô", "Calção de banho"]

function valorAleatorio(array) {
  const indice = Math.floor(Math.random() * array.length);
  return array[indice];
}

export default function () {

  const endpoint = 'endpoint-da-sua-api';

  const params = {
    headers: {
      'Content-Type': 'application/json',
    },
  };

  const payload = JSON.stringify({
    name: valorAleatorio(nomes),
    lastname: valorAleatorio(sobrenomes),
    clothes: [valorAleatorio(roupas), valorAleatorio(roupas), valorAleatorio(roupas)]
  })

  const response = http.post(endpoint, payload, params);

  check(response, {
    'Sucesso': (r) => r.status === 200 || r.status === 201
  })
}