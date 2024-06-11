import http from "k6/http"
import { check } from "k6"

export let options = {
  stages: [
    { duration: '3s', target: 6 },
    { duration: '10s', target: 40 },
    { duration: '30s', target: 80 },
    { duration: '10s', target: 2 },
    { duration: '5s', target: 50 },
    { duration: '10s', target: 100 },
    { duration: '2s', target: 1 }
  ],
  thresholds: {
    http_req_failed: ['rate < 0.02'],
    http_req_duration: ['p(95) < 400']
  }
}

export default function(){
  
  const endpoint = 'endpoint-da-sua-api';
  
  const response = http.get(endpoint)

  check(response, {
    'Sucesso':(r) => r.status === 200
  })
}